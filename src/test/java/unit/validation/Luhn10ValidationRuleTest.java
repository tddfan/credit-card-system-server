package unit.validation;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.CreditCardBuilder;
import com.sapient.test.validator.Luhn10ValidationRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class Luhn10ValidationRuleTest {

    private Luhn10ValidationRule luhn10ValidationRule;

    @Before
    public void setup() {
        luhn10ValidationRule = new Luhn10ValidationRule();
    }


    @Test
    public void testSingleDigit() {
        boolean validationSuccess = getValidationStatusForCardNo("8");
        assertFalse(validationSuccess);
    }


    @Test
    public void testDoubleOfEvenPosFromEndIsLessThen9() {
        boolean validationSuccess = getValidationStatusForCardNo("15");
        assertFalse(validationSuccess);
    }

    @Test
    public void testDoubleOfEvenIsMoreThen9() {
        boolean validationSuccess = getValidationStatusForCardNo("83");
        assertFalse(validationSuccess);
    }


    @Test
    public void testOddDigitsCounts() {
        boolean validationSuccess = getValidationStatusForCardNo("166");
        assertFalse(validationSuccess);
    }

    @Test
    public void testEvenDigitsCounts() {
        boolean validationSuccess = getValidationStatusForCardNo("5166");
        assertFalse(validationSuccess);
    }


    // Test for Null Entity
    // Test for Empty Credit Card No
    // Test for Null Credit Card No
    // Test mix of 0 starts and ends
    // Test of Invalid Card numbers like negative number, special chars

    private boolean getValidationStatusForCardNo(String cardNo) {
        CreditCard card = getCreditCard(cardNo);
        return luhn10ValidationRule.validate(card).isSuccess();
    }

    private CreditCard getCreditCard(String cardNo) {
        return new CreditCardBuilder()
                .setCardNo(cardNo)
                .createCreditCard();
    }
}
