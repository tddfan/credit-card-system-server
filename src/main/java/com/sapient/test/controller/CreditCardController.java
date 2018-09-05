package com.sapient.test.controller;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.CreditCardBuilder;
import com.sapient.test.entity.ValidationResult;
import com.sapient.test.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CreditCardController {

    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ValidationResult add(@RequestBody CreditCard creditCard) {
        return creditCardService.save(creditCard);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<CreditCard> findAll() {
        return creditCardService.findAll();
    }

}
