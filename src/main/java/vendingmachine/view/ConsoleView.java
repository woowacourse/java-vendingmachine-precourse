package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Validator;

public class ConsoleView {

    public static int getMoneyFromUser(String consoleMessage) {
        while (true) {
            try {
                System.out.println(consoleMessage);
                String input = Console.readLine();
                lineFeed();
                Validator.checkNumberFormat(input);
                int number = Integer.parseInt(input);
                Validator.checkPositive(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void lineFeed() {
        System.out.println();
    }

}
