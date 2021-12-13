package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class RandomCoinPicker {
    public static Coin pick(final int maximum) {
        Coin randomCoin;
        do {
            randomCoin = Coin.getCoin(Randoms.pickNumberInList(Coin.getCoinAmountList()));
        } while (randomCoin.getAmount() > maximum);
        return randomCoin;
    }
}
