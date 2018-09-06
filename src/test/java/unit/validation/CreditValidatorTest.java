package unit.validation;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.ValidationResultItem;
import com.sapient.test.validator.CreditCardLengthValidationRule;
import com.sapient.test.validator.CreditCardValidator;
import com.sapient.test.validator.Luhn10ValidationRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditValidatorTest {

    @Mock private Luhn10ValidationRule luhn10ValidationRule;
    @Mock private CreditCardLengthValidationRule creditCardLengthValidationRule;

    private CreditCardValidator creditCardValidator;


    @Before
    public void setup() {
        when(luhn10ValidationRule.validate(any())).thenReturn(new ValidationResultItem("", true));
        when(creditCardLengthValidationRule.validate(any())).thenReturn(new ValidationResultItem("", true));
        creditCardValidator = new CreditCardValidator(luhn10ValidationRule, creditCardLengthValidationRule);
    }

    @Test
    public void testValidationRuleIsInvokedOnce(){
        creditCardValidator.validate(new CreditCard());
        verify(luhn10ValidationRule, times(1)).validate(any());
        verify(creditCardLengthValidationRule, times(1)).validate(any());
    }

    // Test For ValidationResult
    // Test For Message if any failed
    // Test For Message aggregation

}
