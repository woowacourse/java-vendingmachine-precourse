package vendingmachine.domain;

import vendingmachine.domain.enums.Coin;
import vendingmachine.utils.ExceptionMessage;
import vendingmachine.utils.validator.InputNumberValidator;

import java.util.Map;

public class VendingMachine {
    private Changes changes;
    private Beverages beverages;
    private Money money;

    public Changes getChanges() {
        return changes;
    }

    public Beverages getBeverages() {
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

    public Map<Coin, Integer> getReturnChanges() {
        return changes.returnChanges(money.getPrice());
    }

    public void createBeverages(String input){
        beverages = new Beverages();
        beverages.addBeverage(input);
    }

    public void insertMoney(String input) {
        int price = InputNumberValidator.validateInput(input);
        if (beverages.getMinBeveragePrice() > price) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_INSERT_MONEY_NOT_ENOUGH);
        }
        money = new Money(price);
    }

    public boolean isInsertMoneyUnderThanMinBeveragePrice(){
        if (beverages.getMinBeveragePrice() > money.getPrice()){
            return true;
        }
        return false;
    }

}
