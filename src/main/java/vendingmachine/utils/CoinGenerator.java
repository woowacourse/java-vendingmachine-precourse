package vendingmachine.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.HashMap;
import java.util.List;
import vendingmachine.domain.Coin;

public class CoinGenerator {
    private static final int COIN10 = 0;
    private static final int COIN50 = 1;
    private static final int COIN100 = 2;
    private static final int COIN500 = 3;

    public HashMap<Coin, Integer> countCoin(int holdMoney) {
        HashMap<Coin, Integer> map = new HashMap<>();
        int coins[][] = generateByHoldMoney(holdMoney);
        map.put(Coin.COIN_10, coins[COIN10][0]);
        map.put(Coin.COIN_50, coins[COIN50][0]);
        map.put(Coin.COIN_100, coins[COIN100][0]);
        map.put(Coin.COIN_500, coins[COIN500][0]);
        return map;
    }

    private int[][] generateByHoldMoney(int holdMoney) {
        int coins[][] = new int[Coin.values().length][1];
        while (holdMoney > 0) {
            int random = pickNumberInList(List.of(
                    COIN10,
                    COIN50,
                    COIN100,
                    COIN500));
            if (holdMoney > random) {
                holdMoney -= random;
                coins[random][0]++;
            }
        }
        return coins;
    }

}
