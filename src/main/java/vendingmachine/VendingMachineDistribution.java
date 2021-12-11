package vendingmachine;

import models.Coin;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static models.Coin.*;
import static vendingmachine.VendingMachineMain.coin2Num;
import static vendingmachine.VendingMachineMain.totalAmount;


public class VendingMachineDistribution {
    public static void distributeRandomly() {
        ArrayList<Integer> coinList = makeSeeds();
        int total = totalAmount;
        while (true) {
            int seed = pickNumberInList(coinList);
            if (seed == totalAmount || total - seed < 0) {
                continue;
            }
            if (total - seed >= 0) {
                total -= seed;
                countUp(seed);
            }
            if (total == 0) {
                break;
            }
        }
    }

    public static ArrayList<Integer> makeSeeds() {
        ArrayList<Integer> coinList = new ArrayList<>();
        coinList.add(500);
        coinList.add(100);
        coinList.add(50);
        coinList.add(10);
        return coinList;
    }

    public static void countUp(int seed) {
        Coin[] coins = new Coin[] {COIN_500, COIN_100, COIN_50, COIN_10};
        for (Coin coin: coins) {
            if (coin.value() == seed) {
                coin2Num.put(coin, coin2Num.get(coin) + 1);
                break;
            }
        }
    }
}