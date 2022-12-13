package vendingmachine;

import vendingmachine.domain.Product;

public class Validator {

    private Validator () {}
    public static void validateMachineHasMoneyInput(String money) {
        if (Integer.parseInt(money) <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 올바르지 않습니다.");
        }
    }

    public static void validateMachineHasMoneyInputType(String money) {
        String regExp = "^[0-9]+$";
        if (!money.matches(regExp)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public static void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
