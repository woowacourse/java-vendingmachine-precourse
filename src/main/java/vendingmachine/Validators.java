package vendingmachine;
import java.util.regex.Pattern;

public class Validators {
    public static void validateIntegerString(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAmount(String data) {
        validateIntegerString(data);
        if (Integer.parseInt(data) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateItem(String inputData) {
        String[] itemDataList = inputData.split(";");
        String pattern = "\\[[[A-Za-z가-힣0-9ㄱ-ㅎ][\\s]*]+,[0-9]+,[0-9]+\\]";
        for (String itemData : itemDataList) {
            if (!Pattern.matches(pattern, itemData)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
