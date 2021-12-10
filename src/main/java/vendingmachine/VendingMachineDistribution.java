package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import static models.Coin.*;
import static vendingmachine.VendingMachineMain.coin2Num;
import static vendingmachine.VendingMachineMain.totalCoin;

public class VendingMachineDistribution {
    public static void distributeRandomly() {
        int remains = totalCoin;

        if (COIN_500.value() != totalCoin) {
            remains = allocTo500(remains);
        }
        if (COIN_100.value() != totalCoin) {
            remains = allocTo100(remains);
        }
        if (COIN_50.value() != totalCoin) {
            remains = allocTo50(remains);
        }
        if (COIN_10.value() != totalCoin) {
            allocTo10(remains);
        }
    }

    public static int allocTo500(int total) {
        int num = Randoms.pickNumberInRange(0, total / COIN_500.value());
        coin2Num.put(COIN_500, num);
        return total - COIN_500.value() * num;
    }

    public static int allocTo100(int remains) {
        int num = Randoms.pickNumberInRange(0, remains / COIN_100.value());
        coin2Num.put(COIN_100, num);
        return remains - COIN_100.value() * num;
    }

    public static int allocTo50(int remains) {
        int num = Randoms.pickNumberInRange(0, remains / COIN_50.value());
        coin2Num.put(COIN_50, num);
        return remains - COIN_50.value() * num;
    }

    public static void allocTo10(int remains) {
        coin2Num.put(COIN_10, remains / 10);
    }
}