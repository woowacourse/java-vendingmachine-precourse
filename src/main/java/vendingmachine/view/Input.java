package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_VENDING_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_INFO = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_MONEY = "\n투입 금액을 입력해주세요.";
    private static final String BASIC_MONEY = "\n투입 금액: ";
    private static final String BASIC_WON = "원";
    private static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public static String InputVendingMachineChange() {
        System.out.println(INPUT_VENDING_MONEY);
        String inputMoney = Console.readLine();
        return inputMoney;
    }

    public static String InputProductInfo() {
        System.out.println(INPUT_PRODUCT_INFO);
        String productInfo = Console.readLine();
        return productInfo;
    }

    public static String InputMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        return money;
    }

    public static String InputPurchase(int money) {
        System.out.println(BASIC_MONEY + money + BASIC_WON);
        System.out.println(INPUT_PURCHASE_PRODUCT);
        String productName = Console.readLine();
        return productName;
    }
}
