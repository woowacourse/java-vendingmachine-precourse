package vendingmachine.repository;

import java.util.HashMap;

import vendingmachine.domain.Coin;

public class CoinRepository { // 1급 콜렉션
    private HashMap<Coin, Integer> coinRepository;

    public CoinRepository(HashMap<Coin, Integer> coinRepository) {
        this.coinRepository = coinRepository;
    }
}
