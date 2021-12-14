package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int number = 0;
    private List<Integer> coinList;

    Coin(final int amount) {
        this.amount = amount;
    }
    // 추가 기능 구현

    public int getAmount() {
        return amount;
    }

    public int getNumber() {
        return this.number;
    }

    public void increaseNum() {
        this.number++;
    }

    public void decreaseNum(int number) {
        this.number -= number;
    }

    public int createCoinRandom(List<Integer> coins) {
        return Randoms.pickNumberInList(coins);
    }

    public int countMaxFiveHundredCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_500.getAmount();
    }

    public List<Integer> fiveHundredCoins(int maxFiveHundredCoin) {
        List<Integer> fiveHundredCoinList = new ArrayList<>();
        for (int i = 0; i < maxFiveHundredCoin + 1; i++) {
            fiveHundredCoinList.add(i);
        }
        return fiveHundredCoinList;
    }

    public int countMaxOneHundredCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_100.getAmount();
    }

    public List<Integer> oneHundredCoins(int maxOneHundredCoin) {
        List<Integer> oneHundredCoinList = new ArrayList<>();
        for (int i = 0; i < maxOneHundredCoin + 1; i++) {
            oneHundredCoinList.add(i);
        }
        return oneHundredCoinList;
    }

    public int countMaxFiftyCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_50.getAmount();
    }

    public List<Integer> fiftyCoins(int maxFiftyCoin) {
        List<Integer> fiftyCoinList = new ArrayList<>();
        for (int i = 0; i < maxFiftyCoin + 1; i++) {
            fiftyCoinList.add(i);
        }
        return fiftyCoinList;
    }

    public int countMaxTenCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_10.getAmount();
    }
}
