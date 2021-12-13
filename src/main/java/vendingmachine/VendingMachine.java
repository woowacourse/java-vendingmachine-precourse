package vendingmachine;

import vendingmachine.system.Validation;
import vendingmachine.system.ValidationImplementation;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {

    private static final String INPUT_HOLDINGMONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ERROR_INPUT_HOLDINGMONEY_MESSAGE = "[ERROR] 금액은 100 이상 그리고 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다.";
    private final Validation validation;

    public VendingMachine() {
        validation = new ValidationImplementation();
    }

    public void start() {
        inputHoldingMoney();
    }

    public void inputHoldingMoney() {
        boolean isValidInput = false;
        do {
            try {
                printConsoleMessage(INPUT_HOLDINGMONEY_MESSAGE);
                isValidInput = validation.isValidHoldingMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_INPUT_HOLDINGMONEY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
    }

    public void printConsoleMessage(String message) {
        System.out.println(message);
    }

}
