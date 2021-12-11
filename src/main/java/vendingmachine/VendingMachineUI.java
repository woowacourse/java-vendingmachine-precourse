package vendingmachine;

import models.Coin;

import static models.Coin.*;
import static models.Coin.COIN_10;
import static vendingmachine.VendingMachineMain.*;

public class VendingMachineUI {
    public static void printCoins() {
        System.out.println("\n자판기가 보유한 동전");
        Coin[] coinList = {COIN_500, COIN_100, COIN_50, COIN_10};

        for (Coin coin : coinList) {
            System.out.printf("%d원 - %d개\n", coin.value(), coin2Num.get(coin));
        }
    }

    public static void printChange(int[] numOfCoin) {
        System.out.println("\n잔돈");

        Coin[] coinList = {COIN_500, COIN_100, COIN_50, COIN_10};

        for (int i = 0; i < numOfCoin.length; i++) {
            if (numOfCoin[i] != 0) {
                System.out.printf("%d원 - %d개\n", coinList[i].value(), numOfCoin[i]);
            }
        }
    }
}