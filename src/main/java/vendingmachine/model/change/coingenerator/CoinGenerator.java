package vendingmachine.model.change.coingenerator;

import vendingmachine.model.change.vo.Coin;

import java.util.Map;

public interface CoinGenerator {
    Map<Coin, Integer> generate();
}
