package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;


    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public int getAmount(){
        return this.amount;
    }

    public static List<Integer> getCoins(){
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }
    public static int getRandomCoin(){
        return Randoms.pickNumberInList(getCoins());
    }
}
