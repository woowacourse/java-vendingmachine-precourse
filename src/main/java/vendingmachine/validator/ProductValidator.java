package vendingmachine.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.constant.Condition.INDEX_0;
import static vendingmachine.constant.Condition.LENGTH_1;

import vendingmachine.constant.Condition;
import vendingmachine.constant.Error;
import vendingmachine.constant.Input;
import vendingmachine.domain.ProductRepository;

public class ProductValidator {

    public void tryToInputProducts(String[] products) throws IllegalArgumentException {
        validateOnlySemicolon(products);
        validateBlank(products);
        validateBrackets(products);
        validateProductDivisionBySemicolon(products);
        validateProductInformationISThree(products);
        validateProductInfo(products);
    }

    private void validateOnlySemicolon (String[] products) {
        if (products.length == Condition.LENGTH_0.getNumber()) {
            print(Error.ONLY_SEMICOLON_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String[] products) {
        if (products.length == Condition.LENGTH_1.getNumber()) {
            if (products[Condition.INDEX_0.getNumber()].length() == Condition.LENGTH_0.getNumber()) {
                print(Error.PRODUCTS_BLANK_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBrackets(String[] products) {
        for (String product: products) {
            if (!product.startsWith(Input.OPEN_BRACKET.getText())) {
                print(Error.PRODUCT_BRACKETS_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }

            if (!product.endsWith(Input.CLOSE_BRACKET.getText())) {
                print(Error.PRODUCT_BRACKETS_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateProductDivisionBySemicolon (String[] product) {
        for (String productInfo : product) {
            List<String> productInfoToList = Arrays.asList(productInfo.split(""));
            long bracketCount = productInfoToList.stream()
                    .filter(c -> c.equals(Input.OPEN_BRACKET.getText()) || c.equals(Input.CLOSE_BRACKET.getText()))
                    .count();

            if (bracketCount > Condition.BRACKETS_NUMBER.getNumber()) {
                print(Error.PRODUCTS_SEMICOLON_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateProductInformationISThree(String[] products) {
        for (String product : products) {
            String[] productInfo = product.split(Input.COMMA.getText());
            if (productInfo.length != Condition.PRODUCT_INFO_NUMBER.getNumber()) {
                print(Error.PRODUCTS_INFORMATION_NUMBER_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateProductInfo(String[] products) throws IllegalArgumentException {
        for (String product : products) {
            String[] productInfo = product.split(Input.COMMA.getText());
            ArrayList<String> productInfoList = convertProductToList(productInfo);

            validateProductName(productInfoList.get(Condition.INDEX_PRODUCT_NAME.getNumber()));
            validateProductCost(productInfoList.get(Condition.INDEX_PRODUCT_COST.getNumber()));
            validateLimitOfProductCost(productInfoList.get(Condition.INDEX_PRODUCT_COST.getNumber()));
            validateProductAmount(productInfoList.get(Condition.INDEX_PRODUCT_AMOUNT.getNumber()));

            ProductRepository.getInstance().addProduct(productInfoList);
        }
    }

    private void validateProductName(String productName) {
        if (productName.length() == Condition.LENGTH_0.getNumber()) {
            print(Error.PRODUCT_NAME_BLANK_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }

        if (ProductRepository.getInstance().hasSameProduct(productName)) {
            print(Error.PRODUCTS_SAME_NAME_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
    }

    private void validateProductCost (String productCost) {
        if (productCost.length() == Condition.LENGTH_0.getNumber()) {
            print(Error.PRODUCT_COST_BLANK_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
        for (int c = 0; c < productCost.length(); c++) {
            if (!Character.isDigit(productCost.charAt(c))) {
                print(Error.PRODUCT_COST_DIGIT_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateLimitOfProductCost(String productCost) {
        if (Integer.parseInt(productCost) % Condition.DIVIDE_NUMBER.getNumber() != Condition.REMAINDER_0.getNumber()) {
            print(Error.PRODUCT_COST_DIVIDE_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(productCost) < Condition.MINIMUM_COST.getNumber()) {
            print(Error.PRODUCT_MINIMUM_COST_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
    }

    private void validateProductAmount (String productAmount) {
        if (productAmount.length() == 0) {
            print(Error.PRODUCT_AMOUNT_BLANK_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }

        for (int c = 0; c < productAmount.length(); c++) {
            if (!Character.isDigit(productAmount.charAt(c))) {
                print(Error.PRODUCT_AMOUNT_DIGIT_ERROR_MESSAGE.getError());
                throw new IllegalArgumentException();
            }
        }
    }

    private ArrayList<String> convertProductToList(String[] product) {
        ArrayList<String> productInfo = new ArrayList<>();
        for (int i = 0; i < product.length; i++) {
            if (i == Condition.INDEX_PRODUCT_NAME.getNumber()) {
                productInfo.add(product[i].substring(Condition.INDEX_1.getNumber()));
            }
            if (i == Condition.INDEX_PRODUCT_COST.getNumber()) {
                productInfo.add(product[i]);
            }
            if (i == Condition.INDEX_PRODUCT_AMOUNT.getNumber()) {
                productInfo.add(product[i].substring(INDEX_0.getNumber(), product[i].length() - LENGTH_1.getNumber()));
            }
        }
        return productInfo;
    }

    private void print(String message) {
        System.out.println(message);
    }
}
