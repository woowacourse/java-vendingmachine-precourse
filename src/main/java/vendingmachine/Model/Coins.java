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
        String coinName=coinPair.getCoin().name();
        coinName=coinName.substring(5,coinName.length())+"원";

        int requiredCoins=remainMoney/coinPair.getCoin().getAmount();
        if(coinPair.getNumber()==0 || requiredCoins == 0){
            return 0;
        }

        if(requiredCoins>= coinPair.getNumber()){
            System.out.println(coinName+" - "+coinPair.getNumber()+"개");
            return coinPair.getNumber()*coinPair.getCoin().getAmount();
        }

        System.out.println(coinName+" - "+requiredCoins+"개");
        return requiredCoins*coinPair.getCoin().getAmount();
    }
}
