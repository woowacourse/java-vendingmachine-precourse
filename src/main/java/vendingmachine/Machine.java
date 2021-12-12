package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machine {
    private final CoinManager coinManager = new CoinManager();
    private final ProductMap productMap = new ProductMap();
    private int userAmount = 0;

    private static final boolean STOP_WORKING = false;
    private static final boolean KEEP_WORKING = true;

    public Machine() {
    }

    public void workVendingMachine() {
        setCoinsInMachine();
        setProductMap();
        setUserAmount();
        while (keepWorking()) {
            if (sellProduct() == STOP_WORKING) {
                break;
            }
        }
        returnCoin();
    }

    private void setCoinsInMachine() {
        int heldAmount = InputManager.getHeldAmount();
        makeCoins(heldAmount);
    }

    private void makeCoins(int amount) {
        coinManager.makeCoins(amount);
        coinManager.printCoins();
    }

    private void setProductMap() {
        Message.SET_PRODUCT_MAP.print();
        while (true) {
            String productListString;
            try {
                productListString = readLine();
                productMap.toProductMap(productListString);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void setUserAmount() {
        userAmount = InputManager.getUserAmount();
    }

    private boolean keepWorking() {
        System.out.println("\n투입 금액: " + userAmount + "원");
        if (productMap.isWorkable(userAmount)) {
            return KEEP_WORKING;
        }
        return STOP_WORKING;
    }

    private boolean sellProduct() {
        String productName = getProductName();

        int reducedUserAmount = productMap.trySellProduct(productName, userAmount);
        if (isSuccessfulSale(reducedUserAmount, userAmount)) {
            userAmount = reducedUserAmount;
            return KEEP_WORKING;
        }
        return STOP_WORKING;
    }

    private String getProductName() {
        return InputManager.getProductName(productMap);
    }

    private void returnCoin() {
        coinManager.returnCoins(userAmount);
    }

    private boolean isSuccessfulSale(int reducedUserAmount, int userAmount) {
        if (reducedUserAmount < userAmount) {
            return true;
        }
        return false;
    }
}
