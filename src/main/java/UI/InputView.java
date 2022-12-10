package UI;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static Constants.CommonValues.*;
import static Constants.GuideMessages.*;
import Constants.ErrorMessages;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    OutputView outputView = new OutputView();

    public static int askVendingMachineMoney() {
        OutputView.enterVendingMachineMoney();
        return askMoney(ENTER_VENDING_MACHINE_MONEY,MINIMUM_COIN_VALUE);
    }

    public static int askInputMoney() {
        OutputView.enterinputMoney();
        return askMoney(ENTER_INPUT_PRICE,MINIMUM_PRODUCT_VALUE);
    }

    private static int askMoney(String inputMessage,int dividend) {
        while (true) {
            try {
                String input = readLine();
                validateMoney(input, dividend);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()+"\n");
                System.out.println(inputMessage);
            }
        }
    }

    private static void validateMoney(String input, int dividend) {
        Pattern pattern = Pattern.compile(MONEY_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_WRONG_FORMAT_PRODUCT);
        }
        int value = Integer.parseInt(input);
        if (value <= 0 || value % dividend != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NUMBER_OUF_OF_RANGE);
        }
    }

    public static List<String> askProductsInfo() {
        while (true) {
            try {
                OutputView.enterProductInfo();
                String input = readLine();
                validateProductsInfo(input);
                return getProductInfoBunch(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateProductsInfo(String input) {
        Pattern pattern = Pattern.compile(PRODUCT_TOTAL_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_WRONG_FORMAT_PRODUCT);
        }
    }

    private static List<String> getProductInfoBunch(String input) {
        String[] parsed = input.split(";");
        return Arrays.asList(parsed);
    }

    public static String askWishList(int inputMoney) {
        while (true) {
            try {
                OutputView.enterWishList(inputMoney);
                String input = readLine();
                validateWishList(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateWishList(String input) {
        Pattern pattern = Pattern.compile(PURCHASE_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_WRONG_FORMAT_PRODUCT);
        }
    }
}
