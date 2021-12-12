package vendingmachine.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.domain.Coin;

public class RandomCoinCreateStrategy implements CoinCreateStrategy {

    private static final List<Integer> COIN_RANGE = Coin.currentCoinAmounts();

    @Override
    public Coin createCoin() {
        int coin = Randoms.pickNumberInList(COIN_RANGE);
        return Coin.valueOfAmount(coin);
    }
}
