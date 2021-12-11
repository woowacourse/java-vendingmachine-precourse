package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class Change {
    private static final String ERROR_MULTIPLE_OF_TEN = "1원 단위는 허용되지 않습니다.";
    private static final String ERROR_GREATER_THAN_ZERO = "0 이하의 숫자를 입력할 수 없습니다.";
    private static final String ERROR_ONLY_INTEGER = "금액은 숫자만 입력 가능합니다.";
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();
    private static InputMessage inputMessage = new InputMessage();

    public int insertChange() {
        inputMessage.printInsertCoinMessage();
        String changeInVendingMachine = Console.readLine();
        int change = this.validateOnlyInteger(changeInVendingMachine);
        isGreatThanZero(change);
        isMultipleOfTen(change);
        return change;
    }

    public void returnChange(int customerMoney) {
        inputMessage.printChangeMessage();
        for (Coin coin : Coin.values()) {
            int amount = coinMap.get(coin); // amount
            int returnAmount = coin.returnChange(customerMoney, amount);
            coinMap.put(coin, amount - returnAmount);
            customerMoney -= coin.calcChangePrice(returnAmount);
        }
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
        inputMessage.printHaveCoinMessage();
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
