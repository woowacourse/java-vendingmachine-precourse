package vendingmachine;

import static vendingmachine.Coin.*;
import static vendingmachine.Coin.COIN_10;
import static vendingmachine.VendingMachineMain.Coin2Num;

public class VendingMachineUI {
    public static void printCoins() {
        System.out.println("\n자판기가 보유한 동전");

        System.out.printf("500원 - %d개\n", Coin2Num.get(COIN_500));
        System.out.printf("100원 - %d개\n", Coin2Num.get(COIN_100));
        System.out.printf("50원 - %d개\n", Coin2Num.get(COIN_50));
        System.out.printf("10원 - %d개\n", Coin2Num.get(COIN_10));
    }
}