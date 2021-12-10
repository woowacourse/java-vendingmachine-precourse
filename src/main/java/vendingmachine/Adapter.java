package vendingmachine;

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
        vendingMachine.createInputAmount(value);
    }

    private void mapToVendingMachineAmountInputPage() {
        String value = View.putCoinIntoVendingMachine();
        vendingMachine = new VendingMachine(value);
    }

    private void mapToProductRegistrationPage() {
        String value = View.registerProduct();
        try {
            vendingMachine.createProduct(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            mapToProductRegistrationPage();
        }
    }

    private void mapToPurchasePage() {
        boolean canBuy = vendingMachine.checkUserBalance();
        while (canBuy) {
            String value = checkValidProductName();
            vendingMachine.sell(value);
            canBuy = vendingMachine.checkUserBalance();
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
