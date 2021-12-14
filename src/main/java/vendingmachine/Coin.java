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

    public List<Integer> generateCoins(int vendingMachineMoney) {
        List<Integer> coins = new ArrayList<>();
        if (countMaxFiveHundredCoin(vendingMachineMoney) > 0) {
            coins.add(COIN_500.amount);
        }
        if (countMaxOneHundredCoin(vendingMachineMoney) > 0) {
            coins.add(COIN_100.amount);
        }
        if (countMaxFiftyCoin(vendingMachineMoney) > 0) {
            coins.add(COIN_50.amount);
        }
        if (countMaxTenCoin(vendingMachineMoney) > 0) {
            coins.add(COIN_10.amount);
        }
        return coins;
    }

    public int countMaxOneHundredCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_100.getAmount();
    }

    public int countMaxFiftyCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_50.getAmount();
    }

    public int countMaxTenCoin(int vendingMachineMoney) {
        return vendingMachineMoney / COIN_10.getAmount();
    }
}
