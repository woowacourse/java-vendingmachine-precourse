package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class Change {
    private static final String COIN_INSERT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해주세요.";
    private static final String ERROR_MULTIPLE_OF_TEN = "1원 단위는 허용되지 않습니다.";
    private static final String ERROR_GREATER_THAN_ZERO = "0 이하의 숫자를 입력할 수 없습니다.";
    private static final String ERROR_ONLY_INTEGER = "금액은 숫자만 입력 가능합니다.";
    private static final String COIN_NUMBER_PRINT_MESSAGE = "자판기가 보유한 동전";
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();

    public int insertChange() {
        System.out.println(COIN_INSERT_MESSAGE);
        String changeInVendingMachine = Console.readLine();
        int change = this.validateOnlyInteger(changeInVendingMachine);
        isGreatThanZero(change);
        isMultipleOfTen(change);
        return change;
    }

    public void createInitialChanges(int change) {
        int randomNumber;
        for (Coin coin : Coin.values()) {
            randomNumber = coin.createRandomNumber(change);
            change -= coin.getTotalOfCoin(randomNumber);
            coinMap.put(coin, randomNumber);
        }
        printNumberOfCoin();
    }

    private void printNumberOfCoin() {
        System.out.println(COIN_NUMBER_PRINT_MESSAGE);
        for (Coin coin : Coin.values()) {
            coin.printNumberOfCoin(coinMap.get(coin));
        }
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
