package vendingmachine;

public class InputMessage {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final String BUY_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";
    private static final String INSERT_COIN_MESSAGE = "자판기가 보유하고 있는 금액을 입력해주세요.";
    private static final String HAVE_COIN_MESSAGE = "자판기가 보유한 동전";
    private static final String INSERT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";
    private static final String CHANGE_MESSAGE = "잔돈";

    public void printNewLine() {
        System.out.println();
    }

    public void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public void printBuyProductMessage() {
        System.out.println(BUY_PRODUCT_MESSAGE);
    }

    public void printInsertCoinMessage() {
        System.out.println(INSERT_COIN_MESSAGE);
    }

    public void printChangeMessage() {
        System.out.println(CHANGE_MESSAGE);
    }

    public void printHaveCoinMessage() {
        System.out.println(HAVE_COIN_MESSAGE);
    }

    public void printInsertProductMessage() {
        System.out.println(INSERT_PRODUCT_MESSAGE);
    }
}
