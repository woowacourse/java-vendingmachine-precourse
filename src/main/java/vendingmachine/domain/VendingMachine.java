package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class VendingMachine {
    MachineMoney machineMoney;
    Coin coin;

    public void setMachineMoney(String money) throws IllegalArgumentException {
        machineMoney = new MachineMoney(money);
    }

    public Coin getCoin() {
        return coin;
    }

    public void makeRandomAllCoin() {
        for (Coin c : coin.values()) {
            makeRandomCoin(c);
        }
    }

    private void makeRandomCoin(Coin coin) {
        if (coin == Coin.COIN_10) {
            coin.setCount(machineMoney.getMoney() / coin.getAmount());
            return;
        }
        int number = Randoms.pickNumberInRange(0, machineMoney.getMoney() / coin.getAmount());
        machineMoney.minusMoney(coin.getAmount() * number);
        coin.setCount(number);
    }
}

