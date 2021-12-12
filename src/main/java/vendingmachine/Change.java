package vendingmachine;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Change extends LoopInput {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final int ADD_COIN = 1;
    private static final int DEFAULT_STOCK = 0;
    private static final int ZERO = 0;
    private static final Validator validator = new Validator();
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();
    private static OutputMessage outputMessage = new OutputMessage();
    private static int vendingMachineChange;

    public Change() {
        initialCoinMap();
    }

    public void inputMethod() {
        this.inputChange();
    }

    public void returnChange(int customerMoney) {
        outputMessage.printChangeMessage();
        for (Coin coin : Coin.values()) {
            int coinStock = coinMap.get(coin);
            int returnStock = coin.returnChange(customerMoney, coinStock);
            coinMap.put(coin, coinStock - returnStock);
            customerMoney -= coin.calcChangePrice(returnStock);
        }
    }

    public void createRandomChange() {
        int ownChange = vendingMachineChange;
        List<Integer> list = Coin.createCoinAmountList();
        while (ownChange != ZERO) {
            int coinAmount = Randoms.pickNumberInList(list);
            if (coinAmount > ownChange) {
                continue;
            }
            ownChange -= coinAmount;
            Coin coin = Coin.getCoinByAmount(coinAmount);
            coinMap.put(coin, coinMap.get(coin) + ADD_COIN);
        }
        outputMessage.printAllCoin(coinMap);
    }

    private void initialCoinMap() {
        for (Coin coin : Coin.values()) {
            coinMap.put(coin, DEFAULT_STOCK);
        }
    }

    private void inputChange() {
        String inputChange = inputString(INPUT_MONEY_MESSAGE);
        int change = validator.validateOnlyInteger(inputChange);
        validator.isGreatThanZero(change);
        validator.isMultipleOfTen(change);
        vendingMachineChange = change;
    }
}
