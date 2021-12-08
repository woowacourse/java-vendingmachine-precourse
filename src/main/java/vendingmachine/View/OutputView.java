package vendingmachine.View;

import vendingmachine.Model.CoinPair;
import vendingmachine.Model.Coins;

public class OutputView {

    public static void showCoins(Coins coins){
        System.out.println("자판기가 보유한 동전");
        for(CoinPair coin : coins.getCoins()){
            String coinName=coin.getCoin().name();
            coinName=coinName.substring(5,coinName.length())+"원";
            System.out.println(coinName+" - "+coin.getNumber()+"개");
        }
    }
}
