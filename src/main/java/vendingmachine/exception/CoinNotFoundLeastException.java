package vendingmachine.exception;

public class CoinNotFoundLeastException extends RuntimeException {

    private static final String LEAST_COIN_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 최소 coin이 존재하지 않습니다.";

    public CoinNotFoundLeastException() {
        super(LEAST_COIN_NOT_FOUND_ERROR_MESSAGE);
    }
}
