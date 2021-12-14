package vendingmachine.repository;

import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Price;

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

    public LinkedHashMap<Coin, Integer> giveChange(Price userMoney) {
        LinkedHashMap<Coin, Integer> tempCoinRepository = new LinkedHashMap<>();
        int remainingAmount = userMoney.getPrice();

        for (Coin coin : Coin.values()) {
            int givenCoinCnt = determineGivenCoinCnt(remainingAmount, coin);
            tempCoinRepository.put(coin, givenCoinCnt);
            if (givenCoinCnt == 0) {
                continue;
            }
            coinRepository.put(coin, coinRepository.get(coin) - givenCoinCnt);
            remainingAmount -= (givenCoinCnt * coin.getAmount());
        }
        return tempCoinRepository;
    }

    private int determineGivenCoinCnt(int remainingAmount, Coin coin) {
        int maxCntWithoutCondition = remainingAmount / coin.getAmount();
        if (coinRepository.get(coin) <= maxCntWithoutCondition) {
            return coinRepository.get(coin);
        }
        return maxCntWithoutCondition;
    }
}
