package com.sapient.test.validator;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.ValidationResultItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sapient.test.entity.ValidationResultItem.VALIDATION_ITEM_SUCCESS;

@Component
public class MinCardNoValidationRule implements ValidationRule<CreditCard> {

    private static ValidationResultItem FAILURE = ValidationResultItem.failValidation("Card Length Should be between 16 & 19");

    @Override
    public ValidationResultItem validate(CreditCard creditCard) {
        int cardNoLength = getCardNoLength(creditCard);
        boolean success = isValidLength(cardNoLength);
        return getValidationResult(success);
    }

    private boolean isValidLength(int cardNoLength) {
        return cardNoLength >=16 && cardNoLength <= 19;
    }

    private int getCardNoLength(CreditCard creditCard) {
        return creditCard.getCardNo().replaceAll(" +", "").length();
    }

    private ValidationResultItem getValidationResult(boolean success) {
        return success ? VALIDATION_ITEM_SUCCESS :  FAILURE;
    }

}
