package vendingmachine.View;

import vendingmachine.Model.CoinPair;
import vendingmachine.Model.Coins;

public class OutputView {

    public static void showCoins(Coins coins){
        System.out.println("자판기가 보유한 동전");
        for(CoinPair coin : coins.getCoins()){
            System.out.println(coin.getName()+" - "+coin.getNumber());
        }
    }
}
