package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

import static vendingmachine.Coin.*;

public class VendingMachineMain {
    public static int TotalCoin;
    public static HashMap<Coin, Integer> Coin2Num;

    public static void initMachine(int amount) {
        TotalCoin = amount;
        Coin2Num = new HashMap<Coin, Integer>();
        VendingMachineDistribution.distributeRandomly();
        VendingMachineUI.printCoins();
    }
}