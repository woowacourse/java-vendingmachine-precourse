package vendingmachine;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class CoinStore {
    private final Map<Coin, Integer> repository;

    public CoinStore(Map<Coin, Integer> repository) {
        this.repository = repository;
    }

    public void addCoinRandomly(Money money) {
        while (money.isMoreOrEqualThen(Coin.COIN_10.getAmount())) {
            Coin pickedCoin = Coin.getRandomCoin();
            if (money.isLessThen(pickedCoin.getAmount())) {
                continue;
            }
            money.minus(pickedCoin.getAmount());
            addCoin(pickedCoin);
        }
    }

    private void addCoin(Coin coin) {
        repository.put(coin, repository.getOrDefault(coin, 0) + 1);
    }

    public Map<Coin, Integer> getChange(int holdingMoney) {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);
        Coin.getCoinOrderedList()
                .forEach((coin) -> handleChange(change, coin, holdingMoney));
        return change;
    }

    private void handleChange(Map<Coin, Integer> change, Coin coin, int holdingMoney) {
        if (repository.get(coin) == null || repository.get(coin) <= 0) {
            return;
        }
        if (holdingMoney >= coin.getAmount()) {
            int quantity = Math.min(holdingMoney / coin.getAmount(), repository.get(coin));
            change.put(coin, quantity);
            holdingMoney -= coin.getAmount() * quantity;
        }
    }

    public Map<Coin, Integer> getRepository() {
        return Collections.unmodifiableMap(repository);
    }
}
