package vendingmachine;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Change extends LoopInput {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final Validator validator = new Validator();
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();
    private static OutputMessage outputMessage = new OutputMessage();
    private static int initialTotalChange;

    public Change() {
        initialCoinMap();
    }

    private void initialCoinMap() {
        for (Coin coin : Coin.values()) {
            coinMap.put(coin, 0);
        }
    }

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
        outputMessage.printChangeMessage();
        for (Coin coin : Coin.values()) {
            int amount = coinMap.get(coin);
            int returnAmount = coin.returnChange(customerMoney, amount);
            coinMap.put(coin, amount - returnAmount);
            customerMoney -= coin.calcChangePrice(returnAmount);
        }
    }

    public void createRandomChange() {
        List<Integer> list = Coin.createCoinAmountList();
        while (initialTotalChange != 0) {
            int amount = Randoms.pickNumberInList(list);
            if (amount > initialTotalChange) {
                continue;
            }
            initialTotalChange -= amount;
            Coin coin = Coin.getCoinByAmount(amount);
            coinMap.put(coin, coinMap.get(coin) + 1);
        }
        printNumberOfCoin();
    }

    private void printNumberOfCoin() {
        outputMessage.printHaveCoinMessage();
        for (Coin coin : Coin.values()) {
            coin.printNumberOfCoin(coinMap.get(coin));
        }
    }
}
