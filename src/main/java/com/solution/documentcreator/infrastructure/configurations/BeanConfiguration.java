package com.solution.documentcreator.infrastructure.configurations;

import com.solution.documentcreator.entities.ApplicantFactory;
import com.solution.documentcreator.entities.ApplicantFactoryImpl;
import com.solution.documentcreator.usecase.applicant.create_template.CreateApplicantTemplateUseCase;
import com.solution.documentcreator.usecase.applicant.create_template.CreateApplicantTemplateUseCaseImpl;
import com.solution.documentcreator.usecase.applicant.create_template.formats.ApplicantHTMLTemplateBuilder;
import com.solution.documentcreator.usecase.applicant.create_template.formats.ApplicantTemplateBuilder;
import com.solution.documentcreator.usecase.applicant.create_template.ports.TemplateHandler;
import com.solution.documentcreator.usecase.applicant.find.GetApplicantUseCase;
import com.solution.documentcreator.usecase.applicant.find.GetApplicantUseCaseImpl;
import com.solution.documentcreator.usecase.applicant.find.ports.GetApplicantDsGateway;
import com.solution.documentcreator.usecase.shared.template_builders.HTMLTemplateBuilder;
import com.solution.documentcreator.usecase.shared.template_builders.TemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ApplicantFactory createApplicantFactoryImplBean(){
        return new ApplicantFactoryImpl();
    }

    @Bean
    public GetApplicantUseCase createGetApplicantUseCaseBean(GetApplicantDsGateway dsGateway, ApplicantFactory applicantFactory){
        return new GetApplicantUseCaseImpl(dsGateway, applicantFactory);
    }

    @Bean
    public TemplateBuilder createHTMLTemplateBuilderBean(){
        return new HTMLTemplateBuilder();
    }

    @Bean
    public ApplicantTemplateBuilder createApplicantHTMLTemplateBuilderBean(TemplateBuilder builder){
        return new ApplicantHTMLTemplateBuilder(builder);
    }

    @Bean
    public CreateApplicantTemplateUseCase createCreateApplicantTemplateUseCaseBean(ApplicantTemplateBuilder templateBuilder, TemplateHandler handler){
        return new CreateApplicantTemplateUseCaseImpl(templateBuilder, handler);
    }

}
