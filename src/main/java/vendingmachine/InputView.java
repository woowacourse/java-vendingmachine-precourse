package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import validator.InputNumberValidator;
import validator.ProductValidator;
import static validator.InputNumberValidator.validateVendingMachineMoney;

public class InputView {
    private static final String INPUT_VENDING_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_INFORMATION = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_INPUT_MONEY = "\n투입 금액을 입력해 주세요.";
    private static final String INPUT_MONEY = "\n투입 금액: ";
    private static final String UNIT = "원";
    private static final String INPUT_PURCHASE_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";

    public static int inputVendingMachineMoney() {
        try {
            System.out.println(INPUT_VENDING_MACHINE_MONEY);
            return validateVendingMachineMoney(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputVendingMachineMoney();
        }
    }

    public static String inputProductInformation() {
        try {
            System.out.println(INPUT_PRODUCT_INFORMATION);
            return ProductValidator.validateInput(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputProductInformation();
        }
    }

    public static int inputMoney() {
        try{
            System.out.println(INPUT_INPUT_MONEY);
            String inputMoneyResult = Console.readLine();
            InputNumberValidator.isNumber(inputMoneyResult);
            return Integer.parseInt(inputMoneyResult);
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
            return inputMoney();
        }
    }

    public static String inputProductToBuy(int inputMoney) {
        System.out.println(INPUT_MONEY + inputMoney + UNIT);
        System.out.println(INPUT_PURCHASE_PRODUCT_NAME);
        return Console.readLine();
    }


}