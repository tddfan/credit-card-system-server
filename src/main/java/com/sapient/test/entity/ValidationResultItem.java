package com.sapient.test.entity;

public class ValidationResultItem {
    private String message;
    private boolean success;

    public static ValidationResultItem VALIDATION_ITEM_SUCCESS = new ValidationResultItem(true);

    public ValidationResultItem(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ValidationResultItem(boolean success) {
        this.success = success;
    }

    public static ValidationResultItem failWithMessage(String message) {
        return new ValidationResultItem(message, false);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
