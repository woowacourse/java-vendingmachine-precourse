package vendingmachine;
import java.util.regex.Pattern;

public class Validators {
    private static final String ITEM_PATTERN = "\\[[[A-Za-z가-힣0-9ㄱ-ㅎ][\\s]*]+,[0-9]+,[0-9]+\\]";
    private static final String SPLIT_REGEX = ";";
    private static final int UNIT = 10;
    private static final int ZERO = 0;

    public static void validateIntegerString(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAmount(String data) {
        validateIntegerString(data);
        if (Integer.parseInt(data) <= ZERO) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(data) % UNIT != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateItem(String data) {
        String[] itemDataList = data.split(SPLIT_REGEX);
        for (String itemData : itemDataList) {
            if (!Pattern.matches(ITEM_PATTERN, itemData)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateEmptyString(String data) {
        if (data.equals("")) {
            throw new IllegalArgumentException();
        }
    }

}
