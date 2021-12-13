<<<<<<< HEAD

package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int numberOfCoin;

    Coin(final int amount) {
        this.amount = amount;
    }

    public void setNumberOfCoin(int numberOfCoin) {
        this.numberOfCoin = numberOfCoin;
    }

    public int getAmount() {
        return amount;
    }

    public void InputOneCoin() {
        this.numberOfCoin ++;
    }

    public static void SettingCoin(int change) {
        int money = change;
        int[] coins = {10,50,100,500};
        List<Integer> coinNum = Arrays.stream(coins).boxed().collect(Collectors.toList());
        while (money != 0) {
            money -= RandomNumberOfCoin(money,coinNum);
        }
    }

    public static int RandomNumberOfCoin(int change, List<Integer> coinNum) {
        int oneCoin;
        do {
            oneCoin = pickNumberInList(coinNum);
        } while (change < oneCoin);
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == oneCoin) {
                coin.InputOneCoin();
                break;
            }
        }
        return oneCoin;
    }

}
=======
package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int numberOfCoin;

    Coin(final int amount) {
        this.amount = amount;
    }

    public void setNumberOfCoin(int numberOfCoin) {
        this.numberOfCoin = numberOfCoin;
    }

}
>>>>>>> 8d5939b8533e3dbd17938b5e73d73927fe474ffc
