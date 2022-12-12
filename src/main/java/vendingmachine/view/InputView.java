package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.model.Validator.*;
import static vendingmachine.util.message.InputMessage.*;

public class InputView {

    public static int readBalance() {
        System.out.println(BALANCE.fullMessage());
        try {
            return validateBalance(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBalance();
        }
    }

    public static String readProductInfo() {
        System.out.println(PRODUCT_INFO.fullMessage());
        return Console.readLine();
    }


    public static int readAmountOfInput() {
        System.out.println(AMOUNT_OF_INPUT.fullMessage());
        try {
            return validateAmountOfInput(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAmountOfInput();
        }
    }

    public static String readBuyingProduct() {
        System.out.println(BUYING_PRODUCT.fullMessage());
        return Console.readLine();
    }
}
