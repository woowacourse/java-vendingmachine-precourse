package vendingmachine;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machine {
    public NumberManager numberManager = new NumberManager();

    private CoinMap coinMap = new CoinMap();
    private final List<Integer> amountList = new ArrayList<>(Arrays.asList(500, 100, 50, 10));
    public ProductMap productMap = new ProductMap();
    public int userAmount = 0;

    public Machine() {
    }

    public void workVendingMachine() {
        setCoinsInMachine();
        setProductMap();
        setUserAmount();
        while (stopWorking()) {
            sellProduct();
        }
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
            }
        }
    }

    private void makeCoins(int amount) {
        coinMap.makeCoins(amount);
        coinMap.printCoins(coinMap.ALL_PRINT);
    }

    private void setProductMap() {
        System.out.println("상품명과 가격, 수량을 입력해주세요.");
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
        System.out.println("투입 금액을 입력해 주세요.");
        while (true) {
            String userAmountString = readLine();
            try {
                userAmount = numberManager.toNumber(userAmountString, NumberManager.TYPE_AMOUNT);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private static final boolean STOP_WORKING = true;
    private static final boolean KEEP_WORKING = true;

    private boolean stopWorking() {
        if (productMap.getMinAmount()<userAmount) {
            return STOP_WORKING;
        }
        return KEEP_WORKING;
    }

    private void sellProduct() {
        String productName=getProductName();
        if(productMap.isSellable(productName,userAmount)){
            userAmount-=productMap.sellProduct(productName);
            return;
        }
    }
    private String getProductName() {
        System.out.println("투입 금액: " + userAmount + "원");
        System.out.println("구매할 상품명을 입력해 주세요.");
        String productName;

        while (true) {
            try {
                productName=readLine();
                productMap.checkProductExistence(productName);
                return productName;
            } catch (IllegalArgumentException e) {}
        }
    }
}
