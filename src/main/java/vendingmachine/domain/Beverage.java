package vendingmachine.domain;


import vendingmachine.utils.ExceptionMessage;

import static vendingmachine.utils.validator.BeverageValidator.validateInput;

class Beverage {
    private static final int PRODUCT_NAME_IDX = 0;
    private static final int PRICE_IDX = 1;
    private static final int COUNT_IDX = 2;

    private String productName;
    private int price;
    private int count;

    public Beverage(String input) {
        String[] beverageInput = validateInput(input);
        this.productName = beverageInput[PRODUCT_NAME_IDX];
        this.price = Integer.parseInt(beverageInput[PRICE_IDX]);
        this.count = Integer.parseInt(beverageInput[COUNT_IDX]);
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
