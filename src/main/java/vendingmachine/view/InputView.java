package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";

    public static String readProduct() {
        System.out.println(INPUT_PRODUCT);
        String input = Console.readLine().trim();
        validateBlank(input);
        return input;
    }

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
    // TODO 비즈니스 로직 분리
    public static Integer readHoldingMoney() {
        System.out.println(INPUT_MONEY);
        String input = Console.readLine().trim();
        validateBlank(input);
        validateInteger(input);
        return Integer.parseInt(input);
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
