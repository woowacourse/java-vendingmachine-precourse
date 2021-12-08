package vendingmachine.Model;

import java.util.ArrayList;
import java.util.List;

public class Coins {
    private List<CoinPair> coins=new ArrayList<>();

    public void addCoin(Coin coin, int number){
        coins.add(new CoinPair(coin, number));
    }

    public List<CoinPair> getCoins(){
        return coins;
    }
}
