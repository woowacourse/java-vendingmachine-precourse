package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Coin getType(int amount) throws MyIllegalArgumentException {
        switch (amount) {
            case 10:
                return COIN_10;
            case 50:
                return COIN_50;
            case 100:
                return COIN_100;
            case 500:
                return COIN_500;
            default:
                throw new MyIllegalArgumentException(
                        String.format("Invalid unit of coin %d", amount)
                );
        }
    }
}
