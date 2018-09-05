package com.sapient.test.service;

import com.sapient.test.entity.CreditCard;
import com.sapient.test.entity.ValidationResult;
import com.sapient.test.repository.CreditCardRepository;
import com.sapient.test.validator.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    private CreditCardRepository repository;
    private CreditCardValidator creditCardValidator;

    @Autowired
    public CreditCardService(CreditCardRepository repository, CreditCardValidator creditCardValidator) {
        this.repository = repository;
        this.creditCardValidator = creditCardValidator;
    }

    public ValidationResult save(CreditCard creditCard) {
        ValidationResult validationResult = creditCardValidator.validate(creditCard);
        if(validationResult.isSuccess()) {
            repository.save(creditCard);
        }
        return validationResult;
    }

    public List<CreditCard> findAll() {
        return repository.findAll();
    }
}
