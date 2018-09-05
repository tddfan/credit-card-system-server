package com.sapient.test.validator;

import com.sapient.test.entity.ValidationResultItem;

public interface ValidationRule<T> {
    public ValidationResultItem validate(T entity);
}
