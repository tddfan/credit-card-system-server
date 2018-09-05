package com.sapient.test.controller;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.CreditCardBuilder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CreditCardController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody List<String> add(@RequestBody CreditCard creditCard) {
        System.out.println(creditCard);
        return asList("Test");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<CreditCard> findAll() {
        CreditCard c = new CreditCardBuilder().createCreditCard();
        c.setCardNo("789742358");
        c.setLimit(10l);
        c.setName("Sanjay");
        return asList(c);
    }

}
