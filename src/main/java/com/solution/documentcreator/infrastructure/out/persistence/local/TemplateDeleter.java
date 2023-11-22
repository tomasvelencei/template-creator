package com.solution.documentcreator.infrastructure.out.persistence.local;

import com.solution.documentcreator.infrastructure.configurations.TemplateFileConfiguration;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
@Aspect
public class TemplateDeleter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateDeleter.class);
    private final TemplateFileConfiguration configuration;

    public TemplateDeleter(TemplateFileConfiguration configuration) {
        this.configuration = configuration;
    }

    @Pointcut("execution(* com.solution.documentcreator.infrastructure.in.controllers.ApplicantControllerImpl.getApplicantInfoById(..))")
    private void getApplicantInfo() {}

    @AfterReturning(pointcut = "getApplicantInfo()", returning="returnedValue")
    public void afterMethodCall(Object returnedValue) {
        var filename = ((ModelAndView) returnedValue).getViewName();
        this.delayedTemplateDeletion(filename);
    }

    private void delayedTemplateDeletion(String filename) {
        var executor = Executors.newSingleThreadScheduledExecutor();
        var future = executor.schedule(deleteTask(filename), 500, TimeUnit.MILLISECONDS);
        this.closeAfterFinished(executor, future);
    }

    private Runnable deleteTask(String filename) {
        return () -> {
            try {
                var path = configuration.getGeneratedTemplateDirPath()
                        + filename
                        + configuration.getExtension();
                Files.deleteIfExists(Path.of(path));
                LOGGER.info("Template file deleted: {}", path);
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        };
    }

    private void closeAfterFinished(ExecutorService executor, Future future) {
        new Thread(() -> {
            boolean isDone = future.isDone();
            while (!isDone){
                if (future.isDone()) {
                    executor.shutdown();
                    try {
                        if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                            executor.shutdownNow();
                        }
                    } catch (InterruptedException e) {
                        executor.shutdownNow();
                        Thread.currentThread().interrupt();
                    }
                    isDone = true;
                }
            }
            LOGGER.debug("Inner thread has stopped {}", isDone);
        }).start();
    }
}
