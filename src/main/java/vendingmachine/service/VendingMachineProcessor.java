package vendingmachine.service;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class VendingMachineProcessor {
    private static final int OUT_OF_STOCK = 0;
    private final VendingMachine vendingMachine;

    public VendingMachineProcessor(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public VendingMachineChecker purchaseBeverage(String beverageName) {
        Beverages beverages = vendingMachine.getBeverages();
        Money currentMoney = vendingMachine.getMoney();

        Beverage findBeverage = validateCanPurchaseBeverage(beverageName, beverages, currentMoney);
        reduceBeverageAndMoney(findBeverage, currentMoney);

        return validateFinish(beverages);
    }

    private VendingMachineChecker validateFinish(Beverages beverages) {
        if (beverages.getBeverageList().isEmpty()){
            return VendingMachineChecker.CLOSE;
        }

        if(vendingMachine.isInsertMoneyUnderMinBeveragePrice()){
            return VendingMachineChecker.CLOSE;
        }
        return VendingMachineChecker.OPEN;
    }

    private Beverage validateCanPurchaseBeverage(String beverageName, Beverages beverages, Money currentMoney) {
        Beverage findBeverage = beverages.getBeverageByName(beverageName);
        currentMoney.isInsertPriceUnderBeveragePrice(findBeverage.getPrice());
        return findBeverage;
    }

    private void reduceBeverageAndMoney(Beverage findBeverage, Money currentMoney) {
        int restBeverageCount = findBeverage.reduceCount();
        currentMoney.reducePrice(findBeverage.getPrice());

        if(restBeverageCount == OUT_OF_STOCK){
            vendingMachine.getBeverages().removeBeverage(findBeverage);
        }
    }
}
