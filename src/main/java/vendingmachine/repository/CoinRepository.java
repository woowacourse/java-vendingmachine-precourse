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
        LinkedHashMap<Coin, Integer> coinMachineGiveUser = new LinkedHashMap<>();
        int remainingAmount = userMoney.getPrice();

        //coinRepository를 돌면서 큰 거 부터 하나씩 뺀다.
        for (Coin coin : Coin.values()) {
            int givenCoinCnt = 0;
            int maxCntWithoutCondition = remainingAmount / coin.getAmount();
            if (coinRepository.get(coin) <= maxCntWithoutCondition) {
                givenCoinCnt = coinRepository.get(coin);
            } else if(coinRepository.get(coin) > maxCntWithoutCondition) { //else인데 이거 나중에 함수로 뺄거.
                givenCoinCnt = maxCntWithoutCondition;
            }
            coinMachineGiveUser.put(coin, givenCoinCnt);
            remainingAmount -= (givenCoinCnt * coin.getAmount());
        }
        return coinMachineGiveUser;
    }
}
