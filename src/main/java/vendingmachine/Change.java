package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class Change {
    private static final Validator validator = new Validator();
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();
    private static InputMessage inputMessage = new InputMessage();
    private static OutputMessage outputMessage = new OutputMessage();

    public int inputInitialTotalChange() {
        while (true) {
            try {
                return insertChange();
            } catch (IllegalArgumentException exception) {
                outputMessage.printErrorMessage(exception.getMessage());
            }
        }
    }

    public int insertChange() {
        inputMessage.printInsertCoinMessage();
        String changeInVendingMachine = Console.readLine();
        int change = validator.validateOnlyInteger(changeInVendingMachine);
        validator.isGreatThanZero(change);
        validator.isMultipleOfTen(change);
        return change;
    }

    public void returnChange(int customerMoney) {
        inputMessage.printChangeMessage();
        for (Coin coin : Coin.values()) {
            int amount = coinMap.get(coin);
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
}
