package vendingmachine.domain;


import vendingmachine.utils.ExceptionMessage;

import static vendingmachine.utils.validator.BeverageValidator.validateInput;

class Beverage {

    private String productName;
    private int price;
    private int count;

     Beverage(String productName, int price, int count) {
        this.productName = productName;
        this.price = price;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int reduceCount(int numberOfSold){
        isProductCountEnough(numberOfSold);
        count -= numberOfSold;
        return count;
    }

    private void isProductCountEnough(int numberOfSold) {
        if(numberOfSold > count){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_COUNT_OVERFLOW);
        }
    }
}
