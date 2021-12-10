package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.constants.CoinConstants;
import vendingmachine.view.InputView;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private final HashMap<Integer, Integer> coins = new HashMap<>();
    private HashMap<String, List<Integer>> merchandiseInfo;
    private int moneyLeft = 0;

    public VendingMachine() {
        int totalMoney = InputView.getVendingMachineTotalMoneyInput();
        for (Coin value : Coin.values()) {
            this.coins.put(value.getAmount(), 0);
        }
        generateCoins(totalMoney);
    }

    public HashMap<Integer, Integer> getCoins() {
        return this.coins;
    }

    public void setMerchandiseInfo(HashMap<String, List<Integer>> merchandiseInfo) {
        this.merchandiseInfo = merchandiseInfo;
    }

    public void setMoneyLeft(int moneyInput) {
        this.moneyLeft = moneyInput;
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > 0) {
            int randomCoin = Randoms.pickNumberInList(CoinConstants.getCoinValues());
            if (totalMoney >= randomCoin) {
                coins.put(randomCoin, coins.get(randomCoin)+1);
                totalMoney -= randomCoin;
            }
        }
    }
}
