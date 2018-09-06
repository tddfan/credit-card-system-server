package unit.validation;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.CreditCardBuilder;
import com.sapient.test.validator.CreditCardLengthValidationRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardLengthValidatioRuleTest {

    private CreditCardLengthValidationRule rule;

    @Before
    public void setup() {
        rule = new CreditCardLengthValidationRule();
    }

    @Test
    public void testLessThen16Digit() {
        boolean validationStatus = getValidationStatusForCardNo("111122223333444");
        assertFalse(validationStatus);
    }

    @Test
    public void test16Digit() {
        boolean validationStatus = getValidationStatusForCardNo("1111222233334444");
        assertTrue(validationStatus);
    }

    @Test
    public void testMax19Digit() {
        boolean validationStatus = getValidationStatusForCardNo("1111222233334444555");
        assertTrue(validationStatus);
    }

    @Test
    public void testMoreThen19Digit() {
        boolean validationStatus = getValidationStatusForCardNo("11112222333344445555");
        assertFalse(validationStatus);
    }


    private boolean getValidationStatusForCardNo(String cardNo) {
        CreditCard card = getCreditCard(cardNo);
        return rule.validate(card).isSuccess();
    }

    private CreditCard getCreditCard(String cardNo) {
        return new CreditCardBuilder()
                .setCardNo(cardNo)
                .createCreditCard();
    }
}
