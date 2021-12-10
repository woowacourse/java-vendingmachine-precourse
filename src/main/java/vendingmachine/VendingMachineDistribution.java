package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import static vendingmachine.Coin.*;
import static vendingmachine.VendingMachineMain.Coin2Num;
import static vendingmachine.VendingMachineMain.TotalCoin;

public class VendingMachineDistribution {
    public static void distributeRandomly() {
        int remains = TotalCoin;

        if (COIN_500.value() != TotalCoin) {
            remains = allocTo500(remains);
        }
        if (COIN_100.value() != TotalCoin) {
            remains = allocTo100(remains);
        }
        if (COIN_50.value() != TotalCoin) {
            remains = allocTo50(remains);
        }
        if (COIN_10.value() != TotalCoin) {
            allocTo10(remains);
        }
    }

    public static int allocTo500(int total) {
        int num = Randoms.pickNumberInRange(0, total / COIN_500.value());
        Coin2Num.put(COIN_500, num);
        return total - COIN_500.value() * num;
    }

    public static int allocTo100(int remains) {
        int num = Randoms.pickNumberInRange(0, remains / COIN_100.value());
        Coin2Num.put(COIN_100, num);
        return remains - COIN_100.value() * num;
    }

    public static int allocTo50(int remains) {
        int num = Randoms.pickNumberInRange(0, remains / COIN_50.value());
        Coin2Num.put(COIN_50, num);
        return remains - COIN_50.value() * num;
    }

    public static void allocTo10(int remains) {
        Coin2Num.put(COIN_10, remains / 10);
    }
}