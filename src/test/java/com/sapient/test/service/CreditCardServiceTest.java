package com.sapient.test.service;


import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.CreditCardBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditCardServiceTest {
    @Autowired CreditCardService creditCardService;

    @Test
    public void testFindAll() {
        List<CreditCard> creditCards = creditCardService.findAll();
        assertTrue(creditCards.isEmpty());
    }

    @Test
    public void testSave() {
        CreditCard card = new CreditCardBuilder()
                .setCardNo("18")
                .setLimit(10d)
                .setBalance(0d)
                .setName("User")
                .createCreditCard();
        creditCardService.save(card);
        List<CreditCard> cards = creditCardService.findAll();

        assertEquals(1, cards.size());
    }
    // Test for Invalid Card
    // Test validation Result message
}
