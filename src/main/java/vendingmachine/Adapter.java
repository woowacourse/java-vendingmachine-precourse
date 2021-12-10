package vendingmachine;

import vendingmachine.controller.VendingMachine;
import view.View;

public class Adapter {
    private VendingMachine vendingMachine;

    public void run() {
        mapToVendingMachineAmountInputPage();
        mapToProductRegistrationPage();
        mapToUserAmountInputPage();
        mapToPurchasePage();
        vendingMachine.getCoins();
    }

    private void mapToUserAmountInputPage() {
        String value = View.inputAmount();
        vendingMachine.receiveInputAmount(value);
    }

    private void mapToVendingMachineAmountInputPage() {
        String value = View.putCoinIntoVendingMachine();
        vendingMachine = new VendingMachine(value);
    }

    private void mapToProductRegistrationPage() {
        String value = View.registerProduct();
        try {
            vendingMachine.registerProduct(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            mapToProductRegistrationPage();
        }
    }

    private void mapToPurchasePage() {
        boolean canBuy = vendingMachine.canBuyProduct();
        while (canBuy) {
            String value = checkValidProductName();
            vendingMachine.sell(value);
            canBuy = vendingMachine.canBuyProduct();
        }
    }

    private String checkValidProductName() {
        String value = View.buyProduct(vendingMachine.getUserBalance());
        try {
            vendingMachine.checkIsValidProductName(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkValidProductName();
        }
        return value;
    }
}
