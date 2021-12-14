package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.constant.InputViewMessage.*;

public class InputView {
    public static String getVendingMachineAmount() {
        System.out.println(ASKING_VENDING_MACHINE_AMOUNT_MESSAGE);
        return readLine();
    }

    public static String getProducts() {
        System.out.println(ASKING_PRODUCTS_MESSAGE);
        return readLine();
    }

    public static String getUserMoney() {
        System.out.println(ASKING_USER_MONEY_MESSAGE);
        return readLine();
    }

    public static String getProductByUser() {
        System.out.println(ASKING_PRODUCT_BY_USER_MESSAGE);
        return readLine();
    }

}
