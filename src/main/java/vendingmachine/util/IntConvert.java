package vendingmachine.util;

import vendingmachine.exception.IntConvertException;

public class IntConvert {

    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IntConvertException();
        }
    }
}
