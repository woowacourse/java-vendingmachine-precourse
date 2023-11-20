package vendingmachine.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import vendingmachine.exception.VendingMachineException;

public class Reader {
    private Reader() {
    }

    public static int getInteger() {
        String input = Console.readLine();
        return parseInteger(input);
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw VendingMachineException.INVALID_NUMBER_FORMAT.makeException();
        }
    }

    public static String getString() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return input;
        } catch (NoSuchElementException e) {
            throw VendingMachineException.NO_INPUT_FOUNDED.makeException();
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw VendingMachineException.INVALID_STRING_FORMAT.makeException();
        }
    }

    public static List<String> getStrings() {
        String input = Console.readLine();
        validateNotEndWithDelimiter(input);
        return Arrays.stream(input.split(";"))
                .collect(Collectors.toList());
    }

    private static void validateNotEndWithDelimiter(String input) {
        if (input.charAt(input.length() - 1) == ';') {
            throw VendingMachineException.END_WITH_DELIMITER.makeException();
        }
    }

}
