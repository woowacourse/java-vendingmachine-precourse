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
            if (coin.amount == oneCoin) {
                coin.InputOneCoin();
                break;
            }
        }
        return oneCoin;
    }

    public static void PrintNumberOfCoin() {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            System.out.println(coin.amount + "원 - " + coin.numberOfCoin + "개");
        }
        System.out.println();
    }

    public static void PrintChange(int money) {
        System.out.println("투입 금액: " + money + "원");
        System.out.println("잔돈");
        int change = money;
        int numberOfCoin;
        for (Coin coin : Coin.values()) {
            numberOfCoin = Math.min(change / coin.amount,coin.numberOfCoin);
            if (numberOfCoin != 0) {
                System.out.println(coin.amount + "원 - " + numberOfCoin + "개");
                change -= coin.amount * numberOfCoin;
            }
        }
    }
}