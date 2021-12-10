package vendingmachine;

import java.util.HashMap;

public class VendingMachine {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String COIN_NUMBER_PRINT_MESSAGE = "자판기가 보유한 동전";
    private static HashMap<Coin, Integer> numberOfCoins = new HashMap<>();
    private static Change change = new Change();
    private static ProductList productList = new ProductList();

    public VendingMachine() {
        initializeVendingMachine();
    }

    private void initializeVendingMachine() {
        int changeInVendingMachin;
        while (true) {
            try {
                changeInVendingMachin = change.insertChange();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
            }
        }
        while (true) {
            try {
                productList.insertProduct();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
            }
        }
        createNumberOfCoin(changeInVendingMachin);
        printNumberOfCoin();
    }

    private void printNumberOfCoin() {
        System.out.println(COIN_NUMBER_PRINT_MESSAGE);
        for (Coin coin : Coin.values()) {
            coin.printNumberOfCoin(numberOfCoins.get(coin));
        }
    }

    private void createNumberOfCoin(int change) {
        int randomNumber;
        for (Coin coin : Coin.values()) {
            randomNumber = coin.createRandomNumber(change);
            change -= coin.getTotalOfCoin(randomNumber);
            numberOfCoins.put(coin, randomNumber);
        }
    }
}
