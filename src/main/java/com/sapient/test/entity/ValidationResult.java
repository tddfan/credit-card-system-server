package com.sapient.test.entity;

import java.util.List;

public class ValidationResult {

    public static ValidationResult VALIDATION_SUCCESS =  new ValidationResult(true);

    private boolean success;
    private List<String> messages;


    public ValidationResult(boolean success) {
        this.success = success;
    }

    public ValidationResult(boolean success, List<String> messages) {
        this(success);
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
