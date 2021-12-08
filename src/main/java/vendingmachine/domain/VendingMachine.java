package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.utils.validator.BeverageValidator.validateInput;

public class VendingMachine {
    private static final int PRODUCT_NAME_IDX = 0;
    private static final int PRICE_IDX = 1;
    private static final int COUNT_IDX = 2;

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

    public void addBeverage(String input){
        String[] eachBeverageInput = input.split(";");
        for(int i = 0 ; i < eachBeverageInput.length; i++){
            beverages.add(createBeverage(eachBeverageInput[i]));
        }
    }

    private Beverage createBeverage(String eachBeverage) {
        String[] beverageInput = validateInput(eachBeverage);
        int price = Integer.parseInt(beverageInput[PRICE_IDX]);
        int count = Integer.parseInt(beverageInput[COUNT_IDX]);
        return new Beverage(beverageInput[PRODUCT_NAME_IDX], price, count);
    }
}
