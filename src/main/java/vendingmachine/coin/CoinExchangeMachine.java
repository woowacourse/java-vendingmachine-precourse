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
        changeIntoCoins();
        return coins;
    }

    private void initialize(int amountToChange) {
        this.amount = amountToChange;
        coins = new Coins();
        amountsToPick = new ArrayList<>(Coin.getAllDenominations());
    }

    private void changeIntoCoins() {
        while (isMoreThanOrEqualToMinAmountOfCoin(amount)) {
            int pickedAmount = pickCoinAmountRandomly();
            if (pickedAmount > amount) {
                removeAmountFromListToPick(pickedAmount);
                continue;
            }
            changeIntoCoin(pickedAmount);
        }
    }

    private boolean isMoreThanOrEqualToMinAmountOfCoin(int amount) {
        int minAccountOfCoin = Coin.COIN_10.getAmount();
        if (amount >= minAccountOfCoin) {
            return true;
        }
        return false;
    }

    private int pickCoinAmountRandomly() {
        return Randoms.pickNumberInList(amountsToPick);
    }

    private void removeAmountFromListToPick(int pickedAmount) {
        amountsToPick.remove(new Integer(pickedAmount));
    }

    private void changeIntoCoin(int pickedAmount) {
        Coin coin = Coin.findByAmount(pickedAmount).get();
        coins.add(coin);
        amount -= coin.getAmount();
    }
}
