package domain;

import util.CoinGenerator;

public class CoinCountGenerator implements CoinGenerator {

    @Override
    public int generateRandomCoins(Coin coin, int amount) {
        int coinCount = 0;
        while (amount >= coin.getAmount()) {
            Coin randomCoin = Coin.pickRandomWithLimit(amount);
            if (randomCoin == coin) {
                amount -= coin.getAmount();
                coinCount++;
            }
            // 무작위로 선택된 동전이 현재 생성하려는 동전과 같지 않으면 스킵하고 다시 선택
        }
        return coinCount;
    }
}
