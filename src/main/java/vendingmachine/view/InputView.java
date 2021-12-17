package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CHANGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";
    private static final String INPUT_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public void printInputChange() {
        System.out.println(INPUT_CHANGE);
    }

    public void printInputProducts() {
        System.out.println(INPUT_PRODUCTS);
    }

    public void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void printInputBuyProduct() {
        System.out.println(INPUT_BUY_PRODUCT);
    }
}
