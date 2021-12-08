package vendingmachine.Model;

import java.util.ArrayList;
import java.util.List;

public class Coins {
    private static List<CoinPair> coins=new ArrayList<>();

    public static void addCoin(Coin coin, int number){
        coins.add(new CoinPair(coin, number));
    }

    public static List<CoinPair> getCoins(){
        return coins;
    }
}
