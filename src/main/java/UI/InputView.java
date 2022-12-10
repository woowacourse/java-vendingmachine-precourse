package UI;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static Constants.CommonValues.*;
import static Constants.GuideMessages.*;
import static Constants.ErrorMessages.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    OutputView outputView = new OutputView();

    public static int askVendingMachineMoney() {
        OutputView.enterVendingMachineMoney();
        return askMoney(ENTER_VENDING_MACHINE_MONEY);
    }

    public static int askInputMoney() {
        OutputView.enterinputMoney();
        return askMoney(ENTER_INPUT_PRICE);
    }

    private static int askMoney(String inputMessage) {
        while (true) {
            try {
                String input = readLine();
                validateInput(input, MONEY_REGEX, ERROR_WRONG_NUMBER_FORMAT);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
                System.out.println(inputMessage);
            }
        }
    }

    public static List<String> askProductsInfo() {
        while (true) {
            try {
                OutputView.enterProductInfo();
                String input = readLine();
                validateInput(input, PRODUCT_TOTAL_REGEX, ERROR_WRONG_PRODUCT_FORMAT);
                return getProductInfoBunch(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String askWishList(int inputMoney) {
        while (true) {
            try {
                OutputView.enterWishList(inputMoney);
                String input = readLine();
                validateInput(input, PURCHASE_REGEX, ERROR_WRONG_PRODUCT_FORMAT);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> getProductInfoBunch(String input) {
        String[] parsed = input.split(";");
        return Arrays.asList(parsed);
    }

    private static void validateInput(String input, String regex, String errorMessage) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
