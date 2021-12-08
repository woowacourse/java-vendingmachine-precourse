package vendingmachine.view;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    
    public static void printInputAmountMessage() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static void printInputProductMessage() {
        System.out.println(INPUT_PRODUCT_MESSAGE);
    }
}
