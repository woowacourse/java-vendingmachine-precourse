package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.util.Util;
import vendingmachine.util.validator.BudgetValidator;
import vendingmachine.util.validator.MachineMoneyValidator;
import vendingmachine.util.validator.ProductsValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
        INPUT_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
        INPUT_BUDGET("투입 금액을 입력해 주세요."),
        INPUT_PURCHASE_PRODUCT("구매할 상품명을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int readMachineMoney() {
        try {
            System.out.println(ConsoleMessage.INPUT_MACHINE_MONEY.message);
            String input = Console.readLine();
            new MachineMoneyValidator().validate(input);
            return Integer.parseInt(Util.removeSpace(input));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMachineMoney();
        }
    }

    public List<String> readProducts() {
        try {
            System.out.println(ConsoleMessage.INPUT_PRODUCTS.message);
            String input = Console.readLine();
            new ProductsValidator().validate(input);
            List<String> productsInfo = Arrays.asList(Util.removeSpace(input).split(";"));
            return productsInfo;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readProducts();
        }
    }

    public int readBudget() {
        try {
            System.out.println(ConsoleMessage.INPUT_BUDGET.message);
            String input = Console.readLine();
            new BudgetValidator().validate(input);
            return Integer.parseInt(Util.removeSpace(input));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBudget();
        }
    }

    public Product readPurchaseProduct(Products products) {
        try {
            System.out.println(ConsoleMessage.INPUT_PURCHASE_PRODUCT.message);
            return products.findProduct(Util.removeSpace(Console.readLine()));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readPurchaseProduct(products);
        }
    }

}