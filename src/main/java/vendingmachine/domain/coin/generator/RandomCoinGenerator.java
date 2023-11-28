package vendingmachine.domain.coin.generator;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.coin.Coin;

public class RandomCoinGenerator implements CoinGenerator {
    @Override
    public Coin pickCoin() {
        int coinAmount = Randoms.pickNumberInList(coinAmounts);
        return Coin.from(coinAmount);
    }
}
