package vendingmachine;

public class VendingMachineController {
    public static void run() {
        HoldingCoins holdingCoins = getHoldingCoins();
        OutputView.printHoldingCoins(holdingCoins);

        VendingMachine vendingMachine = getVendingMachine(holdingCoins);
        vendingMachine.insertMoney(getInputAmount());

        while (vendingMachine.isPurchasable()) {
            OutputView.printInputAmount(vendingMachine);
            purchaseProduct(vendingMachine);
        }

        OutputView.printInputAmount(vendingMachine);
        OutputView.printChanges(vendingMachine);
    }

    private static void purchaseProduct(VendingMachine vendingMachine) {
        try {
            vendingMachine.buy(InputView.getDemandProductName());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            purchaseProduct(vendingMachine);
        }
    }

    private static VendingMachine getVendingMachine(HoldingCoins holdingCoins) {
        VendingMachine vendingMachine;

        try {
            String productsInfo = InputView.getProductsInfo();
            vendingMachine = new VendingMachine(productsInfo, holdingCoins);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            vendingMachine = getVendingMachine(holdingCoins);
        }

        return vendingMachine;
    }

    private static HoldingCoins getHoldingCoins() {
        HoldingCoins holdingCoins;

        try {
            holdingCoins = new HoldingCoins(InputView.getHoldingAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            holdingCoins = getHoldingCoins();
        }

        return holdingCoins;
    }

    private static int getInputAmount() {
        int inputAmount;

        try {
            inputAmount = InputView.getInputAmount();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            inputAmount = getInputAmount();
        }

        return inputAmount;
    }

}
