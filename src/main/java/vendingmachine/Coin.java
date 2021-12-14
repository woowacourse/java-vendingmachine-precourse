package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    public static final String ERROR_MESSAGE_FOR_INVALID_MONEY_FOR_COIN = "[ERROR] 요청하신 금액에 해당하는 동전이 없습니다 : ";
    public static final String MESSAGE_FORMAT_FOR_COIN_INFO = "%s원 - %s개\n";
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin getCoinByAmount(int amount) {
        if (amount == COIN_500.getAmount()) {
            return COIN_500;
        }
        if (amount == COIN_100.getAmount()) {
            return COIN_100;
        }
        if (amount == COIN_50.getAmount()) {
            return COIN_50;
        }
        if (amount == COIN_10.getAmount()) {
            return COIN_10;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_MONEY_FOR_COIN + amount);
    }

    public String getCoinInfo(int amount) {
        return String.format(MESSAGE_FORMAT_FOR_COIN_INFO, getAmount(), amount);
    }
}
