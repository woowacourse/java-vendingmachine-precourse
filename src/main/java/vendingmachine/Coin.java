package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Coin getCoinWithAmountInput(int amountInput) {
        if (amountInputEquals10(amountInput))
            return COIN_10;
        if (amountInputEquals50(amountInput))
            return COIN_50;
        if (amountInputEquals100(amountInput))
            return COIN_100;
        if (amountInputEquals500(amountInput))
            return COIN_500;

        return null;
    }

    private static boolean amountInputEquals500(int amountInput) {
        return amountInput == 500;
    }

    private static boolean amountInputEquals100(int amountInput) {
        return amountInput == 100;
    }

    private static boolean amountInputEquals50(int amountInput) {
        return amountInput == 50;
    }

    private static boolean amountInputEquals10(int amountInput) {
        return amountInput == 10;
    }

    public int getCount() {return count;}
    public int multiplyAmountAndCount() {
        return amount * count;
    }

    public void addCount() {
        count++;
    }
}
