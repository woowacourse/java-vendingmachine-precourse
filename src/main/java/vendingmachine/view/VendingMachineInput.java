package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Validator;

public class VendingMachineInput {
    private static final String INSERT_AMOUNT_INSTRUCTION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INSERT_PRODUCTS_INSTRUCTION = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INSERT_INPUT_MONEY_INSTRUCTION = "투입 금액을 립력해 주세요.";
    private static final String INSERT_PRODUCT_NAME_TO_BUY_INSTRUCTION = "구매할 상품명을 입력해 주세요.";

    public static int insertAmount() {
        System.out.println(INSERT_AMOUNT_INSTRUCTION);
        String amount = Console.readLine();
        Validator.validateNumber(amount);
        return Integer.parseInt(amount);
    }

    public static String insertProducts() {
        System.out.println(INSERT_PRODUCTS_INSTRUCTION);
        return Console.readLine();
    }

    public static int insertInputMoney() {
        System.out.println(INSERT_INPUT_MONEY_INSTRUCTION);
        String inputMoney = Console.readLine();
        Validator.validateNumber(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static String insertProductNameToBuy() {
        System.out.println(INSERT_PRODUCT_NAME_TO_BUY_INSTRUCTION);
        return Console.readLine();
    }

}
