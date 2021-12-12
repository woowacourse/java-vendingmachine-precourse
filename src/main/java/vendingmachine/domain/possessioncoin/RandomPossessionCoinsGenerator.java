package vendingmachine.domain.possessioncoin;

import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.possessionmoney.PossessionMoney;

public class RandomPossessionCoinsGenerator implements PossessionCoinsGenerator {
    private static final int COINS_DEFAULT_QUANTITY = 0;
    private static final int COIN_ADD_QUANTITY = 1;

    @Override
    public PossessionCoins generate(PossessionMoney possessionMoney) {
        Map<Coin, Integer> possessionCoins = initCoins();
        fillQuantity(possessionCoins, possessionMoney);

        return new PossessionCoins(toPossessionCoinList(possessionCoins));
    }

    private Map<Coin, Integer> initCoins() {
        Map<Coin, Integer> coins = new HashMap<>();

        for (Coin coin : Coin.COINS) {
            coins.put(coin, COINS_DEFAULT_QUANTITY);
        }

        return coins;
    }

    private void fillQuantity(Map<Coin, Integer> possessionCoins, PossessionMoney possessionMoney) {
        while (!possessionMoney.isZero()) {
            Coin randomCoin = getRandomCoin();
            int randomCoinAmount = randomCoin.getAmount();

            if (possessionMoney.isCalculate(randomCoinAmount)) {
                possessionMoney.calculate(randomCoinAmount);
                possessionCoins.put(randomCoin, possessionCoins.get(randomCoin) + COIN_ADD_QUANTITY);
            }
        }
    }

    private Coin getRandomCoin() {
        List<Integer> coinAmounts = Coin.getCoinAmounts();
        int randomAmount = Randoms.pickNumberInList(coinAmounts);

        return Coin.parseCoin(randomAmount);
    }

    private List<PossessionCoin> toPossessionCoinList(Map<Coin, Integer> possessionCoins) {
        return Coin.COINS.stream()
            .map(coin -> new PossessionCoin(coin, possessionCoins.get(coin)))
            .collect(toList());
    }
}