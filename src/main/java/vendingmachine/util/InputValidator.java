package vendingmachine.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static vendingmachine.util.Constants.*;

public class InputValidator {

    public void money(String userInput) {
        boolean regex = Pattern.matches(MACHINE_MONEY_PATTERN, userInput);
        if (!regex) {
            throw new IllegalArgumentException(WRONG_MACHINE_MONEY);
        }
    }

    public void menus(String userInput) {
        String[] menus = userInput.split(SPLIT_MENUS_DELIMETER);
        for (String menu : menus) {
            Pattern pattern = Pattern.compile(MACHINE_MENUS_PATTERN);
            Matcher matcher = pattern.matcher(menu);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(WRONG_MACHINE_MENU);
            }
        }
    }
}
