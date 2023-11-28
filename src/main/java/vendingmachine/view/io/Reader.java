package vendingmachine.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import vendingmachine.exception.VendingMachineException;

public class Reader {

    public int getInteger() {
        String input = Console.readLine();
        return parseInt(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw VendingMachineException.INVALID_NUMBER_FORMAT.makeException();
        }
    }


    public List<String> getStringsWithDelimiter(String delimiter) {
        String input = Console.readLine();
        validateNotEndWithDelimiter(input, delimiter);
        return Arrays.stream(input.split(delimiter))
                .map(menu -> menu.replaceAll(" ", ""))
                .toList();
    }

    private void validateNotEndWithDelimiter(String input, String delimiter) {
        if (input.endsWith(delimiter)) {
            throw VendingMachineException.INVALID_INPUT_FORMAT.makeException();
        }
    }

    public String getString() {
        return Console.readLine();
    }
}
