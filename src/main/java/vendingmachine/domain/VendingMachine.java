package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.constants.CoinConstants;
import vendingmachine.view.InputView;

import java.util.Arrays;
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

    public int getMoneyLeft() {
        return this.moneyLeft;
    }

    public void setMoneyLeft(int moneyInput) {
        this.moneyLeft = moneyInput;
    }

    public void sellMerchandise() {
        String name = InputView.getMerchandiseNameInput();

        List<Integer> info = merchandiseInfo.get(name);
        int price = info.get(0);
        int number = info.get(1);

        moneyLeft -= price;

        merchandiseInfo.put(name, Arrays.asList(price, number-1));
    }

    public boolean canBuyMore() {
        boolean isEnoughMoney = false;
        for (List<Integer> info : merchandiseInfo.values()) {
            int price = info.get(0);
            int number = info.get(1);
            if (number == 0) continue;
            if (moneyLeft >= price) {
                isEnoughMoney = true;
                break;
            }
        }
        return isEnoughMoney;
    }

    public HashMap<Integer, Integer> calculateCoinChanges() {
        HashMap<Integer, Integer> coinChanges = new HashMap<>();
        for (Integer coinValue : CoinConstants.getCoinValuesDesc()) {
            if (this.coins.get(coinValue) == 0) continue;
            if (this.moneyLeft < coinValue) continue;
            int amount = this.moneyLeft/coinValue;
            if (amount > this.coins.get(coinValue)) {
                amount = this.coins.get(coinValue);
            }
            coinChanges.put(coinValue, amount);
            this.coins.put(coinValue, this.coins.get(coinValue)-amount);
            this.moneyLeft -= coinValue * amount;
        }
        return coinChanges;
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > 0) {
            int randomCoin = Randoms.pickNumberInList(CoinConstants.getCoinValuesDesc());
            if (totalMoney >= randomCoin) {
                coins.put(randomCoin, coins.get(randomCoin) + 1);
                totalMoney -= randomCoin;
            }
        }
    }
}
