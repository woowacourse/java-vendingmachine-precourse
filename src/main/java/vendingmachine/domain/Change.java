package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.LoopInput;
import vendingmachine.view.OutputMessage;
import vendingmachine.validator.ValidatorOld;

public class Change extends LoopInput {
    private int inputChange;
    private HashMap<Coin, Integer> coinStorage = new HashMap<>();

    public Change(int inputChange) {
        this.inputChange = inputChange;
        initialCoinStorage();
        createRandomCoin();
    }

    private void initialCoinStorage() {
        for (Coin coin : Coin.values()) {
            coinStorage.put(coin, DEFAULT_STOCK);
        }
    }

    public void createRandomCoin() {
        int ownChange = inputChange;
        List<Integer> list = Coin.getCoinAmountList();
        while (ownChange != ZERO) {
            int coinAmount = Randoms.pickNumberInList(list);
            if (coinAmount > ownChange) {
                continue;
            }
            ownChange -= coinAmount;
            Coin coin = Coin.getCoinByAmount(coinAmount);
            coinStorage.put(coin, coinStorage.get(coin) + ADD_COIN);
        }
    }

    public HashMap<Coin, Integer> getCoinStorage() {
        return coinStorage;
    }

    public void returnChange(Customer customer) {
        for (Coin coin : Coin.values()) {
            int coinStock = coinStorage.get(coin);
            int returnStock = coin.returnChange(customer.getCustomerMoney(), coinStock);
            coinStorage.put(coin, coinStock - returnStock);
            customer.addCoin(coin,returnStock);
        }
    }


    /*********************************************************************/
    // Before
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final int ADD_COIN = 1;
    private static final int DEFAULT_STOCK = 0;
    private static final int ZERO = 0;
    private static final ValidatorOld VALIDATOR_OLD = new ValidatorOld();
    private static HashMap<Coin, Integer> coinMap = new HashMap<>();
    private static OutputMessage outputMessage = new OutputMessage();
    private static int vendingMachineChange;

    public Change() {
        initialCoinMap();
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

    // Before
    private void initialCoinMap() {
        for (Coin coin : Coin.values()) {
            coinMap.put(coin, DEFAULT_STOCK);
        }
    }

    public void inputMethod() {
        this.inputChange();
    }

    // Before
    private void inputChange() {
        String inputChange = inputString(INPUT_MONEY_MESSAGE);
        int change = VALIDATOR_OLD.validateOnlyInteger(inputChange);
        VALIDATOR_OLD.isGreatThanZero(change);
        VALIDATOR_OLD.isMultipleOfTen(change);
        vendingMachineChange = change;
    }
}
