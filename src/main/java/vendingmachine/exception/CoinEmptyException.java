package vendingmachine.exception;

public class CoinEmptyException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_COIN_EMPTY = "[ERROR] 존재하지 않는 코인입니다.";

    public CoinEmptyException() {
        super(EXCEPTION_MESSAGE_COIN_EMPTY);
    }
}
