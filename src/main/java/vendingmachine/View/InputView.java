package vendingmachine.View;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.Messages;
import vendingmachine.utils.RegularExpressions;
import vendingmachine.utils.Symbol;

public class InputView {

    public int inputMoney(final String message) {
        System.out.println(message);

        try {
            String inputMoney = inputValue();
            validateMoney(inputMoney);

            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputMoney(message);
        }
    }

    public List<String> inputProducts(final String message) {
        System.out.println(message);

        try {
            String inputProducts = inputValue();
            validateProducts(inputProducts);
            String noSquareBracketsProducts = deleteSquareBrackets(inputProducts);

            return Arrays.asList(splitInputProducts(noSquareBracketsProducts));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputProducts(message);
        }
    }

    public int inputPurchasingCost() {
        System.out.println();

        return inputMoney(Messages.INPUT_PURCHASING_COST_MESSAGE.getInputMessage());
    }

    public String inputPurchasingProductName(final String message) {
        System.out.println(message);

        try {
            String inputPurchasingProductName = inputValue();
            validateInputPurchasingProductName(inputPurchasingProductName);

            return inputPurchasingProductName;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputPurchasingProductName(message);
        }
    }

    protected void validateMoney(final String inputMoney) {
        if (isNaturalNumber(inputMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_NUMBER.getErrorMessage());
        }
    }

    protected boolean isNaturalNumber(final String inputNumber) {
        return !inputNumber.matches(RegularExpressions.INPUT_NUMBER_REGULAR_EXPRESSION.getRegularExpression());
    }

    protected String[] splitInputProducts(final String inputProducts) {
        return inputProducts.split(Symbol.SEMI_COLON.getSymbol());
    }

    protected String deleteSquareBrackets(final String inputProducts) {
        return inputProducts.replaceAll(Symbol.FRONT_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol())
                .replaceAll(Symbol.REAR_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol());
    }

    protected void validateProducts(final String inputProducts) {
        String[] splitInputProducts = splitInputProducts(inputProducts);

        for (String splitInputProduct : splitInputProducts) {
            if (!isFollowingProductsFormat(splitInputProduct)) {
                throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_INFORMATION_CONDITION.getErrorMessage());
            }
        }
    }

    protected boolean isFollowingProductsFormat(final String inputProduct) {
        return inputProduct.matches(RegularExpressions.INPUT_PRODUCT_INFORMATION_REGULAR_EXPRESSION.getRegularExpression());
    }

    protected void validateInputPurchasingProductName(final String inputPurchasingProductName) {
        if (!isKorean(inputPurchasingProductName)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_NAME_KOREAN.getErrorMessage());
        }
    }

    protected boolean isKorean(final String inputPurchasingProductName) {
        return inputPurchasingProductName.matches(RegularExpressions.PRODUCT_NAME_REGULAR_EXPRESSION.getRegularExpression());
    }

    protected String inputValue() {
        return Console.readLine();
    }

}
