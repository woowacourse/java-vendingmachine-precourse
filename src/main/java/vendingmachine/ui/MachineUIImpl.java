package vendingmachine.ui;

import vendingmachine.Coin;

public class MachineUIImpl implements MachineUI{

    public void showAmount(){
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + Coin.COIN_500.getNumber());
        System.out.println("100원 - " + Coin.COIN_100.getNumber());
        System.out.println("50원 - " + Coin.COIN_50.getNumber());
        System.out.println("10원 - " + Coin.COIN_10.getNumber());
        System.out.println();
    }
    public void showLeftExchange(){
        System.out.println();
    }

}
