package view;

import camp.nextstep.edu.missionutils.Console;
import utils.InputValidator;
import vendingmachine.Products;

public class InputView {

    public static String readAmountInput() {
        String amount = Console.readLine();
        InputValidator.validateBlank(amount);
        InputValidator.validateIsNumeric(amount);
        return amount;
    }

    public static String readOrderDetails() {
        String order = Console.readLine();
        InputValidator.validateBlank(order);
        InputValidator.validateIsOrderFormat(order);
        return order;
    }

    public static String readPurchaseName(Products products) {
        String name = Console.readLine();
        InputValidator.validateBlank(name);
        InputValidator.validatePurchaseProductExist(products, name);
        return name;
    }
}
