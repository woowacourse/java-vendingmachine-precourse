package vendingmachine.domain;


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

}
