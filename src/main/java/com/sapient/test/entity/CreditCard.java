package com.sapient.test.entity;

import java.math.BigDecimal;

public class CreditCard {
    public String name;
    public String cardNo;
    public BigDecimal limit;

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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
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
