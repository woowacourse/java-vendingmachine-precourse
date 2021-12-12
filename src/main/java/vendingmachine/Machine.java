package vendingmachine;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Machine {
    int machineMoney = 0;
    int userMoney = 0;
    boolean continuePurchase = true;
    HashMap<Integer, Integer> coins = new HashMap<>();
    HashMap<String, Integer> menus = new HashMap<>();
    HashMap<String, Integer> stocks = new HashMap<>();

    public void run() {
        inputMachineMoney();
        printMachineCoins();
        inputMachineStocks();
        inputUserMoney();
        purchase();
    }

    private void inputMachineMoney() {
        System.out.println(MACHINE_MONEY_MSG);
        try {
            machineMoney = new InputValidator().money();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            inputMachineMoney();
        }
    }

    private void printMachineCoins() {
        System.out.println(MACHINE_COINS_MSG);
        coins = Coin.randomGenerate(machineMoney);
        for (int coinValue : COINS) {
            System.out.println(coinValue + KRW + MSG_DELIMETER + coins.getOrDefault(coinValue, 0) + EA);
        }
    }

    private void inputMachineStocks() {
        System.out.println(INPUT_MENUS_MSG);
        ArrayList<String[]> inputStocks = new InputValidator().inputStocks();
        for (String[] inputStock : inputStocks) {
            ArrayList<String> stock = new ArrayList<>(Arrays.asList(inputStock));
            String menuName = stock.get(0);
            int menuCost = new InputValidator().checkNumbers(stock.get(1));
            int menuQuantity = new InputValidator().checkNumbers(stock.get(2));
            menus.put(menuName, menuCost);
            stocks.put(menuName, menuQuantity);
        }
    }

    private void inputUserMoney() {
        System.out.println(INPUT_MONEY_MSG);
        userMoney = new InputValidator().money();
    }

    private void purchase() {
        try {
            if (!checkContinuePurchase()) {
                return;
            }
            String userInput = inputPurchaseMenu();
            purchaseStock(userInput);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } finally {
            if (continuePurchase) {
                purchase();
            }
        }
    }

    private boolean checkContinuePurchase() {
        System.out.println(CURR_INPUT_MONEY + userMoney + KRW);
        if (!checkUserMoney() || !checkStocks()) {
            continuePurchase= false;
            printChanges();
            return false;
        }
        return true;
    }

    private String inputPurchaseMenu() {
        System.out.println(PURCHASE_MENU_MSG);
        return new InputValidator().purchaseMenu();
    }

    private void purchaseStock(String userInput) {
        userMoney -= menus.get(userInput);
        stocks.put(userInput, stocks.get(userInput) - 1);
    }

    private int cheapestPrice() {
        int cheapestPrice = Integer.MAX_VALUE;
        for (int price : menus.values()) {
            if (price < cheapestPrice) {
                cheapestPrice = price;
            }
        }
        return cheapestPrice;
    }

    private Boolean checkUserMoney() {
        return userMoney >= cheapestPrice();
    }

    private Boolean checkStocks() {
        for (int countStock : stocks.values()) {
            if (countStock == 0) {
                return false;
            }
        }
        return true;
    }

    private void printChanges() {
        int machineCount = 0, returnCount = 0;
        System.out.println(CHANGES_MSG);
        for (int coin : COINS) {
            try {
                machineCount = coins.get(coin);
                returnCount = Math.min(userMoney / coin, machineCount);
                userMoney -= coin * returnCount;
                coins.replace(coin, machineCount, machineCount - returnCount);
                System.out.println(coin + KRW + MSG_DELIMETER + returnCount + EA);
            } catch (NullPointerException npe) {
                continue;
            }
        }
    }
}
