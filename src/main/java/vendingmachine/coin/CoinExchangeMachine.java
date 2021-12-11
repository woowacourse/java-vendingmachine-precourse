package vendingmachine.coin;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinExchangeMachine {
    private int amount;
    private Coins coins;
    private List<Integer> amountsToPick;

    public Coins changeIntoCoins(int amountToChange) {
        initialize(amountToChange);
        while (isMoreThanOrEqualToMinAmountOfCoin(amount)) {
            int pickedAmount = Randoms.pickNumberInList(amountsToPick);
            if (pickedAmount > amount) {
                amountsToPick.remove(new Integer(pickedAmount));
                continue;
            }
            changeIntoCoin(pickedAmount);
        }
        return coins;
    }

    private void initialize(int amountToChange) {
        this.amount = amountToChange;
        coins = new Coins();
        amountsToPick = new ArrayList<>(Coin.getAllDenominations());
    }

    private void changeIntoCoin(int pickedAmount) {
        Coin coin = Coin.findByAmount(pickedAmount).get();
        coins.add(coin);
        amount -= coin.getAmount();
    }

    private boolean isMoreThanOrEqualToMinAmountOfCoin(int amount) {
        int minAccountOfCoin = Coin.COIN_10.getAmount();
        if (amount >= minAccountOfCoin) {
            return true;
        }
        return false;
    }
}
