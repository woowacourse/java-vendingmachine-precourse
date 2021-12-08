package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessage;
import vendingmachine.utils.validator.BeverageValidator;

import java.util.ArrayList;
import java.util.List;

public class Beverages {
    private static final int PRODUCT_NAME_IDX = 0;
    private static final int PRICE_IDX = 1;
    private static final int COUNT_IDX = 2;

    private static final int NO_BEVERAGE_PRICE = 0;

    private List<Beverage> beverageList = new ArrayList<>();

    public List<Beverage> getBeverageList() {
        return beverageList;
    }

    public void addBeverage(String input) {
        String[] eachBeverageInput = input.split(";");
        for (int i = 0; i < eachBeverageInput.length; i++) {
            Beverage beverage = createBeverage(eachBeverageInput[i]);
            isBeverageDuplicate(beverage);
            beverageList.add(beverage);

        }
    }

    public Beverage getBeverageByName(String beverageName){
        return beverageList.stream()
                .filter(beverage -> beverage.getProductName().equals(beverageName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_NAME));
    }

    public void removeBeverage(Beverage beverage){
        beverageList.remove(beverage);
    }

    public int getMinBeveragePrice() {
        return beverageList.stream()
                .mapToInt(beverage -> beverage.getPrice())
                .min()
                .orElse(NO_BEVERAGE_PRICE);
    }

    private Beverage createBeverage(String eachBeverage) {
        String[] beverageInput = BeverageValidator.validateInput(eachBeverage);
        int price = Integer.parseInt(beverageInput[PRICE_IDX]);
        int count = Integer.parseInt(beverageInput[COUNT_IDX]);
        return new Beverage(beverageInput[PRODUCT_NAME_IDX], price, count);
    }

    private void isBeverageDuplicate(Beverage beverage) {
        if(beverageList.contains(beverage)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_DUPLICATE);
        }
    }
}
