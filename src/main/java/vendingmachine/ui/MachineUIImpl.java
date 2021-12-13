package vendingmachine.ui;

import vendingmachine.Coin;

import java.util.Map;

public class MachineUIImpl implements MachineUI{

    public void showAmount(){
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + Coin.COIN_500.getNumber() + "개");
        System.out.println("100원 - " + Coin.COIN_100.getNumber() + "개");
        System.out.println("50원 - " + Coin.COIN_50.getNumber() + "개");
        System.out.println("10원 - " + Coin.COIN_10.getNumber() + "개");
        System.out.println();
    }
    public void showExchange(Map<String,Integer> exchangedCoins){
        System.out.println("잔돈");
        if(exchangedCoins.get("COIN_500") > 0 ) System.out.println("500원 - " + exchangedCoins.get("COIN_500") + "개");
        if(exchangedCoins.get("COIN_100") > 0) System.out.println("100원 - " + exchangedCoins.get("COIN_100") + "개");
        if(exchangedCoins.get("COIN_50") > 0) System.out.println("50원 - " + exchangedCoins.get("COIN_50") + "개");
        if(exchangedCoins.get("COIN_10") > 0) System.out.println("10원 - " + exchangedCoins.get("COIN_10") + "개");
        System.out.println();
    }

}
