package vendingmachine.Model;

import java.util.ArrayList;
import java.util.List;

public class Coins {
    private static List<CoinPair> coins;

    public Coins(){
        coins=new ArrayList<>();
    }

    public static void addCoin(Coin coin, int number){
        System.out.println(coin+" - "+number); //여기까진 잘되는데...
        coins.add(new CoinPair(coin, number));
    }

    public static List<CoinPair> getCoins(){
        return coins;
    }
}
