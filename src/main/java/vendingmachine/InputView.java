package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NOT_VALID_TYPE_MESSAGE = "올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요. ";
    private static final String NOT_VALID_NUMBER_MESSAGE = "10원으로 나누어 떨어지는 금액을 입력해주세요. ";


    public int inputMoney() {
        while (true) {
            try {
                String inputMoney = Console.readLine();
                return checkValidMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private int checkValidMoney(String inputValue) {

        if (!inputValue.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_VALID_TYPE_MESSAGE);
        }
        int money = Integer.parseInt(inputValue);

        if (money % 10 != 0) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_VALID_NUMBER_MESSAGE);
        }

        return money;

    }
}
