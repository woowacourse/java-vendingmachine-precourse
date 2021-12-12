package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private final HashMap<Integer, Integer> coinTable = new HashMap<>();

    public void generateRandomCoin(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        initCoinTable();
        while (money > 0) {
            int randomNum = Randoms.pickNumberInList(new ArrayList<>(coinTable.keySet()));
            if (randomNum <= money) {
                coinTable.put(randomNum, coinTable.get(randomNum) + 1);
                money -= randomNum;
            }
        }
    }

    private void initCoinTable() {
        for (Coin coin : Coin.values()) {
            coinTable.put(coin.getAmount(), 0);
        }
    }

    public HashMap<Integer, Integer> getCoin() {
        return coinTable;
    }

}
