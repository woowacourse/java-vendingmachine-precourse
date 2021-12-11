package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Product;
import vendingmachine.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_VENDINGMACHINE_SENETENCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_SENETENCE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_USER_PAY_SENETENCE = "투입 금액을 입력해 주세요.";

    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public int inputVendingmachineChange() {
        System.out.println(INPUT_VENDINGMACHINE_SENETENCE);
        String input = Console.readLine();
        try {
            validator.isValidMoney(input);
            return Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputVendingmachineChange();
        }
    }

    public List<Product> inputProductList() {
        System.out.println(INPUT_PRODUCT_SENETENCE);
        String input = Console.readLine();
        try {
            validator.isValidProduct(input);
            return convertStringToProductList(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputProductList();
        }
    }

    public int inputUserPay() {
        System.out.println(INPUT_USER_PAY_SENETENCE);
        String input = Console.readLine();
        try {
            validator.isValidMoney(input);
            return Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUserPay();
        }
    }

    private List<Product> convertStringToProductList(String input) {
        return new ArrayList<>();
    }
}