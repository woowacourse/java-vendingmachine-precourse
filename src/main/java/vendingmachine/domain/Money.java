package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessage;

class Money {
    private int price;

    public Money(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int reducePrice(int paidMoney) {
        isPriceUnderPaidMoney(paidMoney);
        price -= paidMoney;
        return price;
    }

    private void isPriceUnderPaidMoney(int paidMoney) {
        if(paidMoney > price){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_INSERT_MONEY_NOT_ENOUGH);
        }
    }
}
