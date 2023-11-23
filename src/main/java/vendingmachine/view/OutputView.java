package vendingmachine.view;

import java.util.Map;
import vendingmachine.Coin;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public void printCoins(Map<Coin, Integer> coins){
        System.out.println("자판기가 보유한 동전");
        for(Coin coin : Coin.values()){
            int coinCount = coins.getOrDefault(coin,0);
            if(coinCount == 0)
                continue;
            System.out.println(coin.getAmount() + "원 - " + coinCount + "개");
        }
    }
}
