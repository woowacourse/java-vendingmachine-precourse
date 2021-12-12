package vendingmachine.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.domain.Coin;

public class RandomCoinCreateStrategy implements CoinCreateStrategy{

    private static final List<Integer> COIN_RANGE = Coin.currentCoins();

    @Override
    public int createCoin() {
        return Randoms.pickNumberInList(COIN_RANGE);
    }
}
