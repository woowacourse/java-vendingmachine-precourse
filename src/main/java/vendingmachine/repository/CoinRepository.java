package vendingmachine.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;

public class CoinRepository { // 1급 콜렉션
    private LinkedHashMap<Coin, Integer> coinRepository;

    public CoinRepository(LinkedHashMap<Coin, Integer> coinRepository) {
        this.coinRepository = coinRepository;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        coinRepository.keySet()
            .stream()
            .forEach(coin -> sb.append(coin.getAmount() + "원 - " + coinRepository.get(coin) + "개\n"));
        return sb.toString();
    }
}
