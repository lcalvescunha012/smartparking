package com.smartparking.mappers;

import com.smartparking.exceptions.InternalServerErrorException;

import java.util.Arrays;


public interface GenericMapper {

    /**
     * Maps all fields from an instance to another instance, but this instances must to be
     * the same kind of class.
     * */
    default <T> T map(T source, T destination, Class<T> clazz) {

        if(source == null || destination == null)
            throw new InternalServerErrorException("Parsing error.");

        Arrays.asList(clazz.getDeclaredFields()).forEach(field -> {
            try {
                field.setAccessible(true);
                Object value = field.get(source);
                field.set(destination, value);
            } catch (IllegalAccessException e) {
                throw new InternalServerErrorException(e.getMessage());
            }
        });

        return destination;
    }
}
