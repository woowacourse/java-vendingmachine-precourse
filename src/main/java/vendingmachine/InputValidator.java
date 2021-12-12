package vendingmachine;

import static vendingmachine.Constants.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class InputValidator {
    public int money() {
        String userInput = Console.readLine();
        String pattern = "^[1-9]+[0-9]*$";
        boolean regex = Pattern.matches(pattern, userInput);
        if (!regex) {
            throw new IllegalArgumentException(ERROR + WRONG_INPUT_MACHINE_MONEY);
        }
        return Integer.parseInt(userInput);
    }

    public ArrayList<String[]> inputStocks() {
        String userInput = Console.readLine();
        String[] menus = userInput.split(";");
        String pattern = "^([가-힣;,]|\\d)+$";
        ArrayList<String[]> inputStocks = new ArrayList<>();
        for (String menu : menus) {
            menu = menu.replaceAll("(\\[|])", "");
            String[] menuArray = menu.split(",");
            for (String menuElement : menuArray) {
                boolean regex = Pattern.matches(pattern, menuElement);
                if (!regex) {
                    throw new IllegalArgumentException(ERROR + WRONG_INPUT_MENU);
                }
                inputStocks.add(menuArray);
            }
        }
        return inputStocks;
    }

    public int checkNumbers(String inputStr) {
        int result = 0;
        try {
            result = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR + WRONG_INPUT_MENU);
        }
        return result;
    }

    public String purchaseMenu() {
        String userInput = Console.readLine();
        String pattern = "^([가-힣]|\\w|\\d)+$";
        boolean regex = Pattern.matches(pattern, userInput);
        if (!regex) {
            throw new IllegalArgumentException(ERROR + WRONG_INPUT_PURCHASE_MENU);
        }
        return userInput;
    }
}
