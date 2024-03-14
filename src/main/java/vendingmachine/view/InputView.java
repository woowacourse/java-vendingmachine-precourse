package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static int inputInitialMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputString = Console.readLine();
        validateNatural(inputString);
        validateTensMultiple(inputString);
        return Integer.parseInt(inputString);
    }

    public static void validateNatural(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수여야 한다.");
        }

        int inputValue = Integer.parseInt(input);
        if(inputValue<1) throw new IllegalArgumentException("[ERROR] 입력값은 자연수여야 한다.");
    }

    public static void validateTensMultiple(String inputString) {
        int inputValue = Integer.parseInt(inputString);
        if(inputValue%10 == 0) return;
        throw new IllegalArgumentException("[ERROR] 입력값은 10의 배수여야 한다.");
    }
}
