package UI;

import static camp.nextstep.edu.missionutils.Console.readLine;

import Constants.CommonValues;
import Constants.ErrorMessages;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    OutputView outputView = new OutputView();

    public int askVendingMachineMoney() {
        outputView.enterVendingMachineMoney();
        return askMoney(CommonValues.MINIMUM_COIN_VALUE);
    }

    public int askinputMoney() {
        outputView.enterinputMoney();
        return askMoney(CommonValues.MINIMUM_PRODUCT_VALUE);
    }

    private int askMoney(int dividend) {
        while (true) {
            try {
                String input = readLine();
                validateMoney(input,dividend);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoney(String input, int dividend) {
        Pattern pattern = Pattern.compile(CommonValues.MONEY_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_WRONG_FORMAT_PRODUCT);
        }
        int value = Integer.parseInt(input);
        if (value <= 0 || value / dividend != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NUMBER_OUF_OF_RANGE);
        }
    }

    public List<String> askProductsInfo() {
        while (true) {
            try {
                outputView.enterProductInfo();
                String input = readLine();
                List<String> productInfo = validateProductsInfo(input);
                return productInfo;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> validateProductsInfo(String input) {
        Pattern pattern = Pattern.compile(CommonValues.PRODUCT_TOTAL_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_WRONG_FORMAT_PRODUCT);
        }
        List<String> productInfo = new ArrayList<>();
        while(matcher.find()){
            productInfo.add(matcher.group(0));
        }
        return productInfo;
    }


}
