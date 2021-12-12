package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputManager {

    public InputManager() {
    }

    public static int getHeldAmount() {
        Message.GET_HELD_AMOUNT.print();
        System.out.println();
        return getAmount();
    }

    public static int getUserAmount() {
        Message.GET_USER_AMOUNT.print();
        return getAmount();
    }

    public static String getProductName(ProductMap productMap) {
        Message.GET_PRODUCT_NAME.print();
        return getName(productMap);
    }

    private static int getAmount() {
        while (true) {
            String amountString = readLine();
            try {
                int amount = NumberManager.toNumber(amountString, NumberManager.TYPE_AMOUNT);
                return amount;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private static String getName(ProductMap productMap) {
        String productName;

        while (true) {
            try {
                productName = readLine();
                productMap.checkExistence(productName);
                return productName;
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
