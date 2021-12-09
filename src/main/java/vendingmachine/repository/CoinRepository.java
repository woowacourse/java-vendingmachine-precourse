package vendingmachine.repository;

import java.util.HashMap;

import vendingmachine.domain.Coin;

public class CoinRepository { // 1급 콜렉션
    private HashMap<Coin, Integer> coinRepository;

    public CoinRepository(HashMap<Coin, Integer> coinRepository) {
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
