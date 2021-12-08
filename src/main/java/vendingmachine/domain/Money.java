package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessage;

public class Money {
    private int price;

    public Money(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int reducePrice(int paidMoney) {
        price -= paidMoney;
        return price;
    }

    public void isInsertPriceUnderBeveragePrice(int beveragePrice) {
        if(beveragePrice > price){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_INSERT_MONEY_NOT_ENOUGH);
        }
    }
}
