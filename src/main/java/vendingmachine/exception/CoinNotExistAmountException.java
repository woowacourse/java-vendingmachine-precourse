package vendingmachine.exception;

public class CoinNotExistAmountException extends IllegalArgumentException {

    private static final String COIN_NOT_EXIST_ERROR_MESSAGE = "[ERROR] Coin의 종류에 존재하지 않는 Coin입니다.";

    public CoinNotExistAmountException() {
        super(COIN_NOT_EXIST_ERROR_MESSAGE);
    }
}
