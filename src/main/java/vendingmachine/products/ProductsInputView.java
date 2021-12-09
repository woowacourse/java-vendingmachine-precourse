package vendingmachine.products;

import camp.nextstep.edu.missionutils.Console;

public class ProductsInputView {
    private static final String PRODUCTS_INIT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";

    public static String inputProductsInitInfo() {
        System.out.println(PRODUCTS_INIT_MESSAGE);
        return Console.readLine();
    }
}
