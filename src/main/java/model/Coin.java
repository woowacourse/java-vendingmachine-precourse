package model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int num;

    Coin(final int amount) {
        this.amount = amount;
        num = 0;
    }

    // 추가 기능 구현
    public boolean isNonZero(){
        return this.num > 0;
    }
    public static void addCoinNum(int coin) {
        Coin foundCoin = findCoin(coin);
        foundCoin.num++;
    }

    public static void decreaseCoinCount(int coin,int count){
        Coin foundCoin = findCoin(coin);
        foundCoin.num-=count;
    }

    public static Coin findCoin(int coin) {
        return Arrays.stream(Coin.values())
                .filter(c -> c.amount == coin)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] : 맞는 코인을 찾을 수 없습니다."));
    }

    public static List<Integer> getCoinNum() {
        return Arrays.stream(Coin.values())
                .map(c -> c.num)
                .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }

    public int getNum() {
        return num;
    }
}
