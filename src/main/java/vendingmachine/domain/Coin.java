package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private final String coinUnit = "원 - ";
    private int count;
    private final String countUnit = "개";

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }
    // 추가 기능 구현

    public int getAmount() {
        return amount;
    }

    public List<Integer> getAmountList() {
        return Arrays.stream(Coin.values())
                .map(coin -> coin.getAmount())
                .collect(Collectors.toList());
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount(Coin coin) {
        coin.count++;
    }

    public void randomCoinCount(int number) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == number){
                addCount(coin);
            }
        }
    }

    @Override
    public String toString() {
        return amount + coinUnit + count + countUnit;
    }
}
