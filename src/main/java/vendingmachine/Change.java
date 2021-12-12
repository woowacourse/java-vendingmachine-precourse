package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class Change extends LoopInput {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final Validator validator = new Validator();
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();
    private static InputMessage inputMessage = new InputMessage();
    private static int initialTotalChange;

    public void inputMethod() {
        this.inputChange();
    }

    private void inputChange() {
        String changeInVendingMachine = inputString(INPUT_MONEY_MESSAGE);
        int change = validator.validateOnlyInteger(changeInVendingMachine);
        validator.isGreatThanZero(change);
        validator.isMultipleOfTen(change);
        initialTotalChange = change;
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

    public void createInitialChanges() {
        int randomNumber;
        for (Coin coin : Coin.values()) {
            randomNumber = coin.createRandomNumber(initialTotalChange);
            initialTotalChange -= coin.getTotalOfCoin(randomNumber);
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
