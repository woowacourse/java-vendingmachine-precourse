package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int seedMoney = getSeedMoneyFromUser();

    }

    private static int getSeedMoneyFromUser() {
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                String input = Console.readLine();
                assertNumberFormat(input);
                int number = Integer.parseInt(input);
                assertPositiveGreaterThanZero(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void assertPositiveGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상이어야 합니다.");
        }
    }

    private static void assertNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }


}
