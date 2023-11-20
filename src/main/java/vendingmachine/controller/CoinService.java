package vendingmachine.controller;

import java.util.HashMap;
import vendingmachine.domain.Coin;
import vendingmachine.utils.CoinGenerator;

public class CoinService {

    private HashMap<Coin, Integer> coins;

    public void setCoinsByMoney(final Integer holdMoney, CoinGenerator generator) {
        coins = generator.countCoin(holdMoney);
    }
}
