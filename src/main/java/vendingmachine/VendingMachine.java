package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
    private HashMap<Coin, Integer> numberOfCoins = new HashMap<>();

    public VendingMachine() {
        initializeVendingMachine();
    }

    private void initializeVendingMachine() {
        int change;
        while (true) {
            try {
                change = this.insertChange();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR]");
            }
        }
        createNumberOfCoin(change);
        printNumberOfCoin();
    }

    private void printNumberOfCoin() {
        System.out.println("자판기가 보유한 동전");
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

    public int insertChange() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
        String changeInVendingMachine = Console.readLine();
        int change = this.validateOnlyInteger(changeInVendingMachine);
        isGreatThanZero(change);
        isMultipleOfTen(change);
        return change;
    }

    private int validateOnlyInteger(String insertChange) {
        try {
            return Integer.parseInt(insertChange);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void isMultipleOfTen(int change) {
        if (change % 10 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void isGreatThanZero(int change) {
        if (change <= 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
