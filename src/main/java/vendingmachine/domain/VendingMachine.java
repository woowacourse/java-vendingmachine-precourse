package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {
    private HashMap<Coin, Integer> coins = new HashMap<>();
    private int money;

    public VendingMachine(int money) {
        this.money = money;
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
        generateCoins();
        System.out.println(coins);
    }

    private void generateCoins() {
        int localMoney = money;
        List<Integer> random = List.of(500, 100, 50, 10);
        while (localMoney != 0) {
            int randomNumber = Randoms.pickNumberInList(random);

            if (randomNumber == 500 && localMoney >= 500) {
                coins.put(Coin.COIN_500, coins.get(Coin.COIN_500) + 1);
                localMoney -= 500;
            }
            if (randomNumber == 100 && localMoney >= 100) {
                coins.put(Coin.COIN_100, coins.get(Coin.COIN_100) + 1);
                localMoney -= 100;
            }

            if (randomNumber == 50 && localMoney >= 50) {
                coins.put(Coin.COIN_50, coins.get(Coin.COIN_50) + 1);
                localMoney -= 50;
            }

            if (randomNumber == 10) {
                coins.put(Coin.COIN_10, coins.get(Coin.COIN_10) + 1);
                localMoney -= 10;
            }
        }
    }

}
