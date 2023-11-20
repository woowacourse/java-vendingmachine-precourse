package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.message.ExceptionMessage;

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

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
        }
    }
}
