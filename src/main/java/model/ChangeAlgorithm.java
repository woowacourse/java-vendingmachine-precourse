package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeAlgorithm {

    public static List<List<Integer>> proceed(Money inputMoney, Money change) {
        // 남아 있는 투입 금액 만큼 잔돈을 줘야함
        List<List<Integer>> coins = new ArrayList<>();
        for (Coin value : Coin.values()) {
            if (inputMoney.getAmount() >= value.getAmount()) {
                int count = inputMoney.getAmount() / value.getAmount();
                makeChange(coins, value, count);
            }
        }
        return coins;
    }

    private static void makeChange(List<List<Integer>> coins, Coin value, int count) {
        if (value.getNum() >= count) {
            coins.add(Arrays.asList(value.getAmount(), count));
        }
        if (value.getNum() < count) {
            coins.add(Arrays.asList(value.getAmount(), value.getNum()));
        }
    }


}
