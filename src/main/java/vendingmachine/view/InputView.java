package vendingmachine.view;

public class InputView {
    private static final String NEW_LINE = "\n";
    private static final String INPUT_INITIAL_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_USER_INSERT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    
    public static void printInputInitialAmountMessage() {
        System.out.println(INPUT_INITIAL_AMOUNT_MESSAGE);
    }

    public static void printInputProductMessage() {
        System.out.println(INPUT_PRODUCT_MESSAGE);
    }

    public static void printUserInsertAmountMessage() {
        System.out.println(NEW_LINE + INPUT_USER_INSERT_AMOUNT_MESSAGE);
    }
}
