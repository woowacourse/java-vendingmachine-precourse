package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";

    public static String readProduct() {
        System.out.println(INPUT_PRODUCT);
        String input = Console.readLine();
        validate(input);
        return input;
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

}
