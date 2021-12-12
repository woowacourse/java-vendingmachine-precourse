package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputManager {

    public InputManager() {
    }

    public static int getHeldAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return getAmount();
    }

    public static int getUserAmount() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        return getAmount();
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
}
