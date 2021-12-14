package vendingmachine;

public class VendingMachineController {
    public static void run() {
        HoldingCoins holdingCoins = new HoldingCoins(getHoldingAmount());
        OutputView.printHoldingCoins(holdingCoins);

        String productsInfo = getProductsInfo();
        VendingMachine vendingMachine = new VendingMachine(productsInfo, holdingCoins);
        vendingMachine.insertMoney(getInputAmount());

        while (vendingMachine.isPurchasable()) {
            OutputView.printInputAmount(vendingMachine);
            vendingMachine.buy(getDemandProductName());
        }

        OutputView.printInputAmount(vendingMachine);
        OutputView.printChanges(vendingMachine);
    }

    private static String getDemandProductName() {
        String productName;

        try {
            productName = InputView.getDemandProductName();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            productName = getDemandProductName();
        }

        return productName;
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

    private static String getProductsInfo() {
        String productsInfo;

        try {
            productsInfo = InputView.getProductsInfo();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            productsInfo = getProductsInfo();
        }

        return productsInfo;
    }

    private static int getHoldingAmount() {
        int holdingAmount;

        try {
            holdingAmount = InputView.getHoldingAmount();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            holdingAmount = getHoldingAmount();
        }

        return holdingAmount;
    }
}
