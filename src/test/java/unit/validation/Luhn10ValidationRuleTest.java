package unit.validation;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.CreditCardBuilder;
import com.sapient.test.validator.Luhn10ValidationRule;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class Luhn10ValidationRuleTest {

    private Luhn10ValidationRule luhn10ValidationRule;

    @Before
    public void setup() {
        luhn10ValidationRule = new Luhn10ValidationRule();
    }

    //Test for Null Entity
    //Test for Empty Credit Card No
    // Test for Null Credit Card No
    // Test mix of 0 start and ends
    // Test of Invalid Card numbers like negative number, special chars

    @Test
    public void testSingleDigit() {
        assertFalse("Single Digit Should always fails validation",
                luhn10ValidationRule.validate(getCreditCard("8")).isSuccess());
    }

    @Test
    public void testDoubleOfEvenIsLessThen9_Invalid() {
        assertFalse("card no where double of even position has value less then 9 and sum doesnt add up tp 10 should fail",
                luhn10ValidationRule.validate(getCreditCard("15")).isSuccess());
    }

    @Test
    public void testDoubleOfEvenIsLessThen9_Valid() {
        assertTrue("card no where double of even position has value less then 9 and sum adds up tp 10 should pass",
                luhn10ValidationRule.validate(getCreditCard("67")).isSuccess());
    }

    @Test
    public void testDoubleOfEvenIsMoreThen9_Invalid() {
        assertFalse("card no where double of even position has value more then 9 and sum doesnt add up tp 10 should fail",
                luhn10ValidationRule.validate(getCreditCard("85")).isSuccess());
    }

    @Test
    public void testDoubleOfEvenIsMoreThen9_Valid() {
        assertTrue("card no where double of even position has value more then 9 and sum adds up tp 10 should pass",
                luhn10ValidationRule.validate(getCreditCard("67")).isSuccess());
    }

    @Test
    public void testOddDigitsCounts_Valid() {
        assertTrue("Odd Digit Card no with valid Luhn 10 should should pass",
                luhn10ValidationRule.validate(getCreditCard("166")).isSuccess());
    }

    private CreditCard getCreditCard(String cardNo) {
        return new CreditCardBuilder()
                .setCardNo(cardNo)
                .createCreditCard();
    }
}
