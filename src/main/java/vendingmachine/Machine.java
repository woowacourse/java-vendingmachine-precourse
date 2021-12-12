package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machine {
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
        System.out.println("\n상품명과 가격, 수량을 입력해주세요.");
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
        if (productMap.isSellable(productName, userAmount)) {
            userAmount -= productMap.sellProduct(productName);
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

}
