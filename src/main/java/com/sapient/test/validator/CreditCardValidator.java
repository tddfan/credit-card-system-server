package com.sapient.test.validator;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.ValidationResult;
import com.sapient.test.entity.ValidationResultItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.sapient.test.entity.ValidationResult.VALIDATION_SUCCESS;
import static java.util.stream.Collectors.toList;

@Component
public class CreditCardValidator {

    private List<ValidationRule> rules;

    @Autowired
    public CreditCardValidator(Luhn10ValidationRule luhn10ValidationRule, CreditCardLengthValidationRule creditCardLengthValidationRule) {
        rules = new ArrayList<>();
        rules.add(luhn10ValidationRule);
        rules.add(creditCardLengthValidationRule);
    }

    public ValidationResult validate(CreditCard creditCard) {
        List<ValidationResultItem> validationResultItems = getValidationResults(creditCard);
        return validationSummary(validationResultItems);
    }

    private List<ValidationResultItem> getValidationResults(CreditCard creditCard) {
        return rules.stream()
                .map(rule -> rule.validate(creditCard))
                .collect(toList());
    }


    private ValidationResult validationSummary(List<ValidationResultItem> validationResultItems) {
        boolean validationFailed = hasValidationFailed(validationResultItems);
        return validationFailed ? getFailedResults(validationResultItems) : VALIDATION_SUCCESS;
    }

    private ValidationResult getFailedResults(List<ValidationResultItem> validationResultItems) {
        List<String> messages = validationResultItems.stream()
                .map(validationResultItem -> validationResultItem.getMessage())
                .filter(msg -> !StringUtils.isEmpty(msg))
                .collect(toList());
        return new ValidationResult(false, messages);
    }

    private boolean hasValidationFailed(List<ValidationResultItem> validationResultItems) {
        return validationResultItems
                .stream()
                .anyMatch(result -> !result.isSuccess());

    }

}
