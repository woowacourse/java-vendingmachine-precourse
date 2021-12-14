package vendingmachine.View;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.InputOutputMessages;
import vendingmachine.utils.RegularExpressions;
import vendingmachine.utils.Symbol;

public class InputView {

    public int inputMoney(final String message) {
        try {
            System.out.println(message);
            String inputMoney = inputValue();

            isNaturalNumber(inputMoney);
            int money = Integer.parseInt(inputMoney);
            isOverZero(money);

            return money;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputMoney(message);
        }
    }

    public List<String> inputProducts(final String message) {
        System.out.println(message);

        try {
            String inputProducts = inputValue();
            isFollowingProductsFormat(inputProducts);
            String noSquareBracketsProducts = deleteSquareBrackets(inputProducts);

            return Arrays.asList(splitInputProducts(noSquareBracketsProducts));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputProducts(message);
        }
    }

    public int inputPurchasingCost() {
        System.out.println();

        return inputMoney(InputOutputMessages.INPUT_PURCHASING_COST_MESSAGE.getInputMessage());
    }

    public String inputPurchasingProductName(final String message) {
        System.out.println(message);

        try {
            String inputPurchasingProductName = inputValue();
            isKorean(inputPurchasingProductName);

            return inputPurchasingProductName;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputPurchasingProductName(message);
        }
    }

    protected void isOverZero(final int inputMoney) {
        if(inputMoney == 0){
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_LESS_THAN_ZERO.getErrorMessage());
        }
    }

    protected void isNaturalNumber(final String inputMoney) {
        if (!inputMoney.matches(RegularExpressions.INPUT_NUMBER_REGULAR_EXPRESSION.getRegularExpression())) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_NUMBER.getErrorMessage());
        }
    }

    protected String[] splitInputProducts(final String inputProducts) {
        return inputProducts.split(Symbol.SEMI_COLON.getSymbol());
    }

    protected String deleteSquareBrackets(final String inputProducts) {
        return inputProducts.replaceAll(Symbol.FRONT_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol())
                .replaceAll(Symbol.REAR_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol());
    }

    protected void isFollowingProductsFormat(final String inputProducts) {
        String[] splitInputProducts = splitInputProducts(inputProducts);

        for (String splitInputProduct : splitInputProducts) {
            if (!splitInputProduct.matches(RegularExpressions.INPUT_PRODUCT_INFORMATION_REGULAR_EXPRESSION.getRegularExpression())) {
                throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_INFORMATION_CONDITION.getErrorMessage());
            }
        }
    }

    protected void isKorean(final String inputPurchasingProductName) {
        if (!inputPurchasingProductName.matches(RegularExpressions.PRODUCT_NAME_REGULAR_EXPRESSION.getRegularExpression())) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_NAME_KOREAN.getErrorMessage());
        }
    }

    protected String inputValue() {
        return Console.readLine();
    }

}
