package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBalance() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int balance;
        try {
            balance = validateNum();
            if (balance % 10 != 0) {
                throw new IllegalArgumentException("보유 금액은 10의 배수여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            balance = readBalance();
        }
        return balance;
    }

    public static String readProductInfo() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static int readAmountOfInput() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        int amountOfInput = 0;
        try {
            amountOfInput = validateNum();
            if (amountOfInput < 0) {
                throw new IllegalArgumentException("투입 금액은 음수일 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            amountOfInput = readAmountOfInput();
        }
        return amountOfInput;
    }

    private static int validateNum() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
