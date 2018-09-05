package com.sapient.test.entity;

public class CreditCardBuilder {
    private Long id;
    private String name;
    private String cardNo;
    private double limit;
    private double balance;

    public CreditCardBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public CreditCardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CreditCardBuilder setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public CreditCardBuilder setLimit(double limit) {
        this.limit = limit;
        return this;
    }
    public CreditCardBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }



    public CreditCard createCreditCard() {
        return new CreditCard(id, name, cardNo, limit, balance);
    }
}