package vendingmachine.Model;

import java.util.ArrayList;
import java.util.List;

public class Coins {
    private List<CoinPair> coins = new ArrayList<>();

    public void addCoin(Coin coin, int number) {
        coins.add(new CoinPair(coin, number));
    }

    public List<CoinPair> getCoins() {
        return coins;
    }

    public void calculateChange(int remainMoney){
        for(CoinPair coinPair : coins){
            remainMoney-=payCoin(coinPair, remainMoney);
        }
    }
    private int payCoin(CoinPair coinPair, int remainMoney){
        int requiredCoins=remainMoney/coinPair.getCoin().getAmount();
        if(requiredCoins>= coinPair.getNumber()){
            System.out.println(coinPair.getCoin().name()+" - "+coinPair.getNumber());
            return coinPair.getNumber()*coinPair.getCoin().getAmount();
        }

        System.out.println(coinPair.getCoin().name()+" - "+requiredCoins);
        return requiredCoins*coinPair.getCoin().getAmount();
    }
}
