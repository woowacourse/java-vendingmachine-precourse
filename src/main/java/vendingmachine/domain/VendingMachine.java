package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessage;
import vendingmachine.utils.validator.BeverageValidator;
import vendingmachine.utils.validator.InputNumberValidator;

import java.util.ArrayList;
import java.util.List;


public class VendingMachine {
    private static final int PRODUCT_NAME_IDX = 0;
    private static final int PRICE_IDX = 1;
    private static final int COUNT_IDX = 2;

    private static final int NO_BEVERAGE_PRICE = 0;

    private Changes changes;
    private List<Beverage> beverages = new ArrayList<>();
    private Money money;

    public Changes getChanges() {
        return changes;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public Money getMoney() {
        return money;
    }

    public void createChanges(String input) {
        int totalChanges = InputNumberValidator.validateInput(input);
        changes = new Changes(totalChanges);
        changes.createRandomCoins();
    }

    public void addBeverage(String input) {
        String[] eachBeverageInput = input.split(";");
        for (int i = 0; i < eachBeverageInput.length; i++) {
            beverages.add(createBeverage(eachBeverageInput[i]));
        }
    }

    public Beverage getBeverageByName(String beverageName){
        return beverages.stream()
                    .filter(beverage -> beverage.getProductName().equals(beverageName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_NAME));
    }

    public void removeBeverage(Beverage beverage){
        beverages.remove(beverage);
    }

    public void insertMoney(String input) {
        int price = InputNumberValidator.validateInput(input);
        if (getMinBeveragePrice() > price) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_INSERT_MONEY_NOT_ENOUGH);
        }
        money = new Money(price);
    }

    private Beverage createBeverage(String eachBeverage) {
        String[] beverageInput = BeverageValidator.validateInput(eachBeverage);
        int price = Integer.parseInt(beverageInput[PRICE_IDX]);
        int count = Integer.parseInt(beverageInput[COUNT_IDX]);
        return new Beverage(beverageInput[PRODUCT_NAME_IDX], price, count);
    }

    private int getMinBeveragePrice() {
        return beverages.stream()
                .mapToInt(beverage -> beverage.getPrice())
                .min()
                .orElse(NO_BEVERAGE_PRICE);
    }
}
