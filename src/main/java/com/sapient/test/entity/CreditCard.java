package com.sapient.test.entity;

public class CreditCard {
    private Long id;
    public String name;
    public String cardNo;
    public double limit;

    public CreditCard(Long id, String name, String cardNo, double limit) {
        this.id = id;
        this.name = name;
        this.cardNo = cardNo;
        this.limit = limit;
    }
    public CreditCard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", limit=" + limit +
                '}';
    }
}
