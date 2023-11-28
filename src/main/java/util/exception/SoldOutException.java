package util.exception;

public class SoldOutException extends IllegalArgumentException{

    public static final String ERROR_MESSAGE = "품절된 상품은 구매할 수 없습니다.";
    public SoldOutException() {
        super(ERROR_MESSAGE);
    }
}
