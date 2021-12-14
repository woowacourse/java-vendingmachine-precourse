package vendingmachine.domain.coin;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinExchangeMachine {
    private int amount = 0;
    private Coins coins = new Coins();
    private List<Integer> amountsToPick = new ArrayList<>();

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
        if (Coin.COIN_10.hasMoreAmount(amount)) {
            return false;
        }
        return true;
    }

    private int pickCoinAmountRandomly() {
        return Randoms.pickNumberInList(amountsToPick);
    }

    private void removeAmountFromListToPick(int pickedAmount) {
        amountsToPick.remove(new Integer(pickedAmount));
    }

    private void changeIntoCoin(int pickedAmount) {
        coins.add(Coin.findByAmount(pickedAmount).get());
        amount -= pickedAmount;
    }
}
