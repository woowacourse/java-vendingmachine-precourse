package vendingmachine.service;

import vendingmachine.view.InputViews;

import static vendingmachine.view.Messages.*;


public class MachineCoinService {

    public static int getInitMachineMoney() {
        while (true) {
            String input = InputViews.inputInitMachineMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                checkDivideByTen(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkNotString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void checkPositiveNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }

    public static void checkDivideByTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_BY_TEN);
        }
    }
}
