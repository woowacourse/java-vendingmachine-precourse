package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import vendingmachine.util.ExceptionMessage;
import vendingmachine.util.Util;
import vendingmachine.util.validator.MachineMoneyValidator;
import vendingmachine.util.validator.ProductsValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
        INPUT_PRODUCTS("상품명과 가격, 수량을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int readMachineMoney() {
        System.out.println(ConsoleMessage.INPUT_MACHINE_MONEY.message);
        String input = Console.readLine();
        new MachineMoneyValidator().validate(input);
        return Integer.parseInt(Util.removeSpace(input));
    }

    public List<String> readProducts() {
        System.out.println(ConsoleMessage.INPUT_PRODUCTS.message);
        String input = Console.readLine();
        new ProductsValidator().validate(input);
        List<String> productsInfo = Arrays.asList(input.split(";"));
        return productsInfo;
    }

    private static void validate(List<String> productsInfo) {

    }
}