package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String ERROR_MULTIPLE_OF_TEN = "1원 단위는 허용되지 않습니다.";
    private static final String ERROR_GREATER_THAN_ZERO = "0 이하의 숫자를 입력할 수 없습니다.";
    private static final String ERROR_ONLY_INTEGER = "금액은 숫자만 입력 가능합니다.";
    private static final String COIN_INSERT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해주세요.";
    private static final String COIN_NUMBER_PRINT_MESSAGE = "자판기가 보유한 동전";
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
                System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
            }
        }
        createNumberOfCoin(change);
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

    public int insertChange() {
        System.out.println(COIN_INSERT_MESSAGE);
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
            throw new IllegalArgumentException(ERROR_ONLY_INTEGER);
        }
    }

    private void isMultipleOfTen(int change) {
        if (change % 10 != 0) {
            throw new IllegalArgumentException(ERROR_MULTIPLE_OF_TEN);
        }
    }

    private void isGreatThanZero(int change) {
        if (change <= 0) {
            throw new IllegalArgumentException(ERROR_GREATER_THAN_ZERO);
        }
    }
}
