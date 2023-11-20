package vendingmachine.message;

public class ViewMessage {
    public static final String INPUT_HOLDING_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_INSERTED_MONEY = "투입 금액을 입력해 주세요.";
    public static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public static final String OUTPUT_HOLDING_COIN_PRE_MESSAGE = "자판기가 보유한 동전";
    public static final String OUTPUT_CHANGE = "잔돈";
    public static final String OUTPUT_COIN_FORMAT = "%d원 - %d개\n";
    public static final String OUTPUT_MONEY_FORMAT = "투입 금액: %d원\n";
}
