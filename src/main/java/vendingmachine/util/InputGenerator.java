package vendingmachine.util;

import vendingmachine.util.constant.InputCondition;
import vendingmachine.util.constant.Symbol;

public final class InputGenerator {

    public static int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String[] splitBySemiColon(String input) {
        return input.split(Symbol.SEMICOLON);
    }

    public static String[] splitByComma(String input) {
        return input.split(Symbol.COMMA);
    }

    public static String[][] splitMerchandiseInfo(String input) {
        String[] merchandiseInfo = splitBySemiColon(input);
        String[][] merchandise = new String[merchandiseInfo.length][];

        for (int i = 0; i < merchandiseInfo.length; i++) {
            merchandiseInfo[i] = merchandiseInfo[i].replaceAll(InputCondition.SQUARE_BRACKET_REGEX, Symbol.BLANK);
            merchandise[i] = splitByComma(merchandiseInfo[i]);
        }
        return merchandise;
    }
}
