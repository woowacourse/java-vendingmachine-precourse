package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count;
    private int countForChange;

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

    private void reduceCount() {
        count--;
    }

    private void addChangeCount() {
        countForChange++;
    }

    public boolean hasCountForChange() {
        return countForChange > 0;
    }

    public int reduceChangeAsCoinAmount(int changeAmount) {
        return changeAmount - amount;
    }

    public boolean isPossible(int changeAmount) {
        if (hasCoin() && isLessThanChangeAmount(changeAmount)) {
            addChangeCount();
            reduceCount();
            return true;
        }
        return false;
    }

    private boolean isLessThanChangeAmount(int changeAmount) {
        return amount <= changeAmount;
    }

    private boolean hasCoin() {
        return count > 0;
    }

    // for test
    public boolean isChangeCount(int targetCount) {
        return countForChange == targetCount;
    }

    public String getCountForChangeMessage() {
        return amount + "원 - " + countForChange + "개";
    }

    public String getCountForMessage() {
        return amount + "원 - " + count + "개";
    }
}
