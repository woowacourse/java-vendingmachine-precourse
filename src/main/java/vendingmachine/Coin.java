package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final int START_OF_RANGE = 0;
    private static final String PRINT_MESSAGE_NUMBER_OF_COIN_PREFIX = "원 - ";
    private static final String PRINT_MESSAGE_NUMBER_OF_COIN_SUFFIX = "개";
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int createRandomNumber(int change) {
        if (this == COIN_10) {
            return change / this.amount;
        }
        int max = change / this.amount;
        return Randoms.pickNumberInRange(START_OF_RANGE, max);
    }

    public int getTotalOfCoin(int randomNumber) {
        return this.amount * randomNumber;
    }

    public void printNumberOfCoin(int number) {
        System.out.println(this.amount + PRINT_MESSAGE_NUMBER_OF_COIN_PREFIX + number + PRINT_MESSAGE_NUMBER_OF_COIN_SUFFIX);
    }
}
