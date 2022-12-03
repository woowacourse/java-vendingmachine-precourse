package vendingmachine.vendingmachine;

import java.util.Arrays;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, final int count) {
        this.amount = amount;
        this.count = count;
    }


    // 추가 기능 구현
    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public void addCoin() {
        count++;
    }

    public static Coin getCoin(int amount) {
        return Arrays.stream(values()).filter(a -> a.getAmount() == amount).findAny().orElse(null);
    }

    public static StringBuilder makeCoinList() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values()).forEach(coin -> sb.append(coin.getAmount()).append("원 - ").append(coin.getCount()).append("개").append("\n"));
        return sb;
    }


}
