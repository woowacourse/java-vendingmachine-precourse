package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.OutputView.LINE_SEPARATOR;

public class InputView {
    private static final String INPUT_VENDING_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCTS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final String INPUT_PRODUCT_TO_PURCHASE = "구매할 상품명을 입력해 주세요.";


    public static String inputVendingMachineMoney() {
        System.out.println(INPUT_VENDING_MACHINE_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputProducts() {
        System.out.println(LINE_SEPARATOR + INPUT_PRODUCTS_MESSAGE);
        return Console.readLine();
    }

    public static String inputMoney() {
        System.out.println(LINE_SEPARATOR + INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputProductToPurchase() {
        System.out.println(INPUT_PRODUCT_TO_PURCHASE);
        return Console.readLine();
    }
}
