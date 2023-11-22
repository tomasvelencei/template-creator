package com.solution.documentcreator.infrastructure.out.persistence.db.converters;


public interface EntityConverter<T, P> {

    T mapToEntity(final P dsRequest);
    P mapToDsResponse(final T entity);
}
