package vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.RegularExpressions;
import vendingmachine.utils.Symbol;

public class VendingMachineService {

    public static final int PRODUCT_INFORMATION_NAME_INDEX = 0;
    public static final int PRODUCT_INFORMATION_PRICE_INDEX = 1;
    public static final int PRODUCT_INFORMATION_COUNT_INDEX = 2;

    public void isFollowingProductsFormat(final List<String> inputProducts) {
        for (String inputProduct : inputProducts) {

            if (!isMatches(inputProduct)) {
                throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_INFORMATION_FORMAT.getErrorMessage());
            }

        }
    }

    protected boolean isMatches(final String inputProduct) {
        return inputProduct.matches(RegularExpressions.INPUT_PRODUCT_INFORMATION_REGULAR_EXPRESSION.getRegularExpression());
    }

    public void validateMachineMoney(final String inputMachineMoney) {
        if(isNaturalNumber(inputMachineMoney)){
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_NUMBER.getErrorMessage());
        }

        if (!isMultiplyTen(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_UNIT.getErrorMessage());
        }
    }

    protected boolean isMultiplyTen(final String inputMachineMoney) {
        return (Integer.parseInt(inputMachineMoney) % 10) == 0;
    }

    protected boolean isNaturalNumber(final String inputNumber) {
        return !inputNumber.matches(RegularExpressions.INPUT_NUMBER_REGULAR_EXPRESSION.getRegularExpression());
    }

    public String deleteSquareBrackets(final String inputProducts) {
        return inputProducts.replaceAll(Symbol.FRONT_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol())
                .replaceAll(Symbol.REAR_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol());
    }

    public String[] splitInputProducts(final String inputProducts) {
        return inputProducts.split(Symbol.SEMI_COLON.getSymbol());
    }

    public List<Product> addProduct(final List<String> inputProductList) {
        final List<Product> productList = new ArrayList<>();

        for (String inputProduct : inputProductList) {
            final List<String> productInformation = Arrays.asList(inputProduct.split(Symbol.COMMA.getSymbol()));
            Product product = createProduct(productInformation);

            productList.add(product);
        }

        return productList;
    }

    protected Product createProduct(final List<String> productInformation) {
        String name = productInformation.get(PRODUCT_INFORMATION_NAME_INDEX);
        int price = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_PRICE_INDEX));
        int count = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_COUNT_INDEX));

        return new Product(name, price, count);
    }

    public void validateInputPurchasingCost(final String inputPurchasingCost) {
        if (isNaturalNumber(inputPurchasingCost)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_PURCHASING_COST.getErrorMessage());
        }
    }

}
