package com.sapient.test.validator;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.ValidationResultItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sapient.test.entity.ValidationResultItem.VALIDATION_ITEM_SUCCESS;

@Component
public class Luhn10ValidationRule implements ValidationRule<CreditCard> {

    private static ValidationResultItem FAILURE = ValidationResultItem.failWithMessage("Invalid Credit Card Number");

    @Override
    public ValidationResultItem validate(CreditCard creditCard) {
        List<Integer> cardDigits = getCreditCardNoAsIntList(creditCard.getCardNo());
        int totalDigitsSum = getDigitsSum(cardDigits);
        return getValidationResult(totalDigitsSum);
    }

    private List<Integer> getCreditCardNoAsIntList(String cardNo) {
        cardNo = removeWhiteSpaces(cardNo);
        return Stream.of(cardNo.split(""))
                .map(str -> Integer.parseInt(str))
                .collect(Collectors.toList());
    }

    private int getDigitsSum(List<Integer> cardDigits) {
        return sumOfOddPosDigitsFromEnd(cardDigits)
                + sumOfEvenPosDigitFromEnd(cardDigits);
    }

    private int sumOfOddPosDigitsFromEnd(List<Integer> cardDigits) {
        int sum = 0;
        for (int i = cardDigits.size() - 1; i >= 0; i = i-2) {
            sum = sum + cardDigits.get(i);
        }
        return sum;
    }

    private int sumOfEvenPosDigitFromEnd(List<Integer> cardDigits) {
        int sum = 0;
        for (int i = cardDigits.size() - 2; i >= 0; i = i-2) {
            sum = sum + doubleItAndSinglify(cardDigits.get(i));
        }
        return sum;
    }

    private int doubleItAndSinglify(Integer val) {
        int doubleVal = val * 2;
        return doubleVal > 9 ? doubleVal - 9 : doubleVal;
    }

    private String removeWhiteSpaces(String cardDigits) {
        return cardDigits.replaceAll(" +", "");
    }

    private ValidationResultItem getValidationResult(int totalDigitsSum) {
        return isValidLuhnDigit(totalDigitsSum) ? VALIDATION_ITEM_SUCCESS :  FAILURE;
    }

    private boolean isValidLuhnDigit(int totalDigitsSum) {
        return totalDigitsSum % 10 == 0;
    }
}
