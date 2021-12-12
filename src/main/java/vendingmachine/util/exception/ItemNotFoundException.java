package vendingmachine.util.exception;

public class ItemNotFoundException extends IllegalArgumentException{
    public static final String NOT_EXIST_ITEM_EXCEPTION = "[ERROR] 존재하지 않는 아이템입니다.";

    public ItemNotFoundException() {
        super(NOT_EXIST_ITEM_EXCEPTION);
    }
}
