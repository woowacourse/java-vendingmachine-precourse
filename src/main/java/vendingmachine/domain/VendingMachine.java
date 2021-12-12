package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.view.InputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private final HashMap<Coin, Integer> coinCounter = new HashMap<>();
    private HashMap<String, List<Integer>> merchandiseInfo;
    private int moneyLeft = 0;

    public VendingMachine() {
        int totalMoney = InputView.getVendingMachineTotalMoneyInput();
        for (Coin coin : Coin.values()) {
            this.coinCounter.put(coin, 0);
        }
        generateCoins(totalMoney);
    }

    public HashMap<Coin, Integer> getCoins() {
        return this.coinCounter;
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

    public HashMap<Coin, Integer> calculateCoinChanges() {
        HashMap<Coin, Integer> coinChanges = new HashMap<>();
        for (Coin coin : Coin.getCoinsDesc()) {
            if (this.coinCounter.get(coin) == 0) continue;
            if (this.moneyLeft < coin.getAmount()) continue;
            int spentCoinNumber = this.moneyLeft/coin.getAmount();
            if (spentCoinNumber > this.coinCounter.get(coin)) {
                spentCoinNumber = this.coinCounter.get(coin);
            }
            coinChanges.put(coin, spentCoinNumber);
            this.coinCounter.put(coin, this.coinCounter.get(coin)-spentCoinNumber);
            this.moneyLeft -= coin.getAmount() * spentCoinNumber;
        }
        return coinChanges;
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > 0) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinsAmountDesc());
            if (totalMoney >= randomCoinAmount) {
                Coin newCoin = Coin.getCoinByAmount(randomCoinAmount);
                coinCounter.put(newCoin, coinCounter.get(newCoin) + 1);
                totalMoney -= randomCoinAmount;
            }
        }
    }
}
