package vendingmachine.exception;

public class MoneyShareByLeastCoin extends IllegalArgumentException {

    private static final String MONEY_SHARE_BY_LEAST_COIN_ERROR_MESSAGE = "[ERROR] 금액은 10원으로 나누어떨어지는 금액만 입력할 수 있습니다.";

    public MoneyShareByLeastCoin() {
        super(MONEY_SHARE_BY_LEAST_COIN_ERROR_MESSAGE);
    }
}
