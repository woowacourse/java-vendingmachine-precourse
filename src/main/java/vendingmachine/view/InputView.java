package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.message.ViewMessage;

public class InputView {



    public static String readString(String message) {
        System.out.println(message);
        String input = Console.readLine().trim();
        validateBlank(input);
        return input;
    }

    public static int readInteger(String message) {
        System.out.println(message);
        String input = Console.readLine().trim();
        validateBlank(input);
        validateInteger(input);
        return Integer.parseInt(input);
    }

    public static String readProduct() {
        System.out.println(ViewMessage.INPUT_PRODUCT);
        String input = Console.readLine().trim();
        validateBlank(input);
        return input;
    }

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("금액은 숫자여야 합니다.");
        }
    }

    public static Integer readInputMoney() {
        System.out.println();
        System.out.println("투입할 금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        validateBlank(input);
        validateInteger(input);
        return Integer.parseInt(input);
    }

    public static String readPurchaseProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String input = Console.readLine().trim();
        validateBlank(input);
        return input;
    }
}
