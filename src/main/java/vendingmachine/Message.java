package vendingmachine;

public enum Message {
    SET_PRODUCT_MAP("\n상품명과 가격, 수량을 입력해주세요."),
    GET_HELD_AMOUNT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    GET_USER_AMOUNT("\n투입 금액을 입력해 주세요."),
    GET_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    PRINT_COINS("\n자판기가 보유한 동전"),
    RETURN_COINS("잔돈"),
    OUT_OF_STOCK("해당 상품 재고가 없습니다!"),
    EXCESS_AMOUNT("금액이 부족합니다!");

    private final String message;
    Message(String message){
        this.message=message;
    }

    public void print(){
        System.out.println(message);
    }
}
