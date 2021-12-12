package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machine {
    private final NumberManager numberManager = new NumberManager();
    private final CoinManager coinManager = new CoinManager();
    private final ProductMap productMap = new ProductMap();
    private int userAmount = 0;

    private static final boolean STOP_WORKING = true;
    private static final boolean KEEP_WORKING = false;

    public Machine() {
    }

    public void workVendingMachine() {
        setCoinsInMachine();
        setProductMap();
        setUserAmount();
        while (stopWorking() == KEEP_WORKING) {
            if (sellProduct() == STOP_WORKING) {
                break;
            }
        }
        returnCoin();
    }

    private void setCoinsInMachine() {
        int heldAmount = getHeldAmountInMachine();
        makeCoins(heldAmount);
    }

    private int getHeldAmountInMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        while (true) {
            String heldAmountString = readLine();
            try {
                int heldAmount = numberManager.toNumber(heldAmountString, NumberManager.TYPE_AMOUNT);
                return heldAmount;
            } catch (IllegalArgumentException e) {
                coinManager.resetCoinCount();
            }
        }
    }

    private void makeCoins(int amount) {
        coinManager.makeCoins(amount);
        coinManager.printCoins();
    }

    private void setProductMap() {
        System.out.println("\n상품명과 가격, 수량을 입력해주세요.");
        while (true) {
            String productListString;
            try {
                productListString = readLine();
                productMap.toProductMap(productListString);
                return;
            } catch (IllegalArgumentException e) {
                productMap.resetProductMap();
            }
        }
    }

    private void setUserAmount() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        while (true) {
            String userAmountString = readLine();
            try {
                userAmount = numberManager.toNumber(userAmountString, NumberManager.TYPE_AMOUNT);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private boolean stopWorking() {
        System.out.println("\n투입 금액: " + userAmount + "원");
        if (productMap.isWorkable(userAmount)) {
            return KEEP_WORKING;
        }
        return STOP_WORKING;
    }

    private boolean sellProduct() {
        String productName = getProductName();
        if (productMap.isSellable(productName, userAmount)) {
            userAmount -= productMap.sellProduct(productName);
            return KEEP_WORKING;
        }
        return STOP_WORKING;
    }

    private String getProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String productName;

        while (true) {
            try {
                productName = readLine();
                productMap.checkProductExistence(productName);
                return productName;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void returnCoin() {
        coinManager.returnCoins(userAmount);
    }

}
