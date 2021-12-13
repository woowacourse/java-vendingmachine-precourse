package vendingmachine.view;

public enum InputData {
    ASK_BUDGET("자판기가 보유하고 있는 금액을 입력해 주세요."),
    ASK_PRODUCTS_TO_SET("상품명과 가격, 수량을 입력해 주세요."),
    ASK_INPUT_MONEY("투입 금액을 입력해 주세요."),
    ASK_PRODUCT_TO_BUY("구매할 상품명을 입력해 주세요.");

    private final String data;

    InputData(final String data) {
        this.data = data;
    }

    public String toString(){
        return data;
    }
}
