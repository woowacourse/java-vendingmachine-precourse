package vendingmachine.validator;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;

class ProductValidatorTest {

    private void validateConditionOfProductCost(String productCost) {
        if (Integer.parseInt(productCost) % Condition.DIVIDE_NUMBER.getNumber() != Condition.REMAINDER_0.getNumber()) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(productCost) < Condition.MINIMUM_COST.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateProductInformationISThree(String[] products) {
        for (String product : products) {
            String[] productInfo = product.split(Input.COMMA.getText());
            if (productInfo.length != Condition.PRODUCT_INFO_NUMBER.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBrackets(String[] products) {
        for (String product: products) {
            if (!product.startsWith(Input.OPEN_BRACKET.getText())) {
                throw new IllegalArgumentException();
            }

            if (!product.endsWith(Input.CLOSE_BRACKET.getText())) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateProductDivisionBySemicolon(String[] product) {
        for (String productInfo : product) {
            List<String> productInfoToList = Arrays.asList(productInfo.split(""));
            long bracketCount = productInfoToList.stream()
                    .filter(c -> c.equals(Input.OPEN_BRACKET.getText()) || c.equals(Input.CLOSE_BRACKET.getText()))
                    .count();

            if (bracketCount > Condition.BRACKETS_NUMBER.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Test
    void 상품_가격_10의_배수() {
        assertThrows(IllegalArgumentException.class, () -> validateConditionOfProductCost("101"));

        assertDoesNotThrow(() -> validateConditionOfProductCost("110"));
    }

    @Test
    void 상품_가격_100_이상() {
        assertThrows(IllegalArgumentException.class, () -> validateConditionOfProductCost("90"));

        assertDoesNotThrow(() -> validateConditionOfProductCost("100"));
    }

    @Test
    void 상품_정보_3개_확인() {
        String[] product1 = {"사이다,1000,10", "콜라,1500"};
        assertThrows(IllegalArgumentException.class, () -> validateProductInformationISThree(product1));

        String[] product2 = {"사이다,1000,10", "콜라,1500,5"};
        assertDoesNotThrow(() -> validateProductInformationISThree(product2));
    }


    @Test
    void 개별_상품_대괄호_형식_확인() {
        String[] products1 = {"[사이다,1000,10]", "콜라,1500,5]"};
        assertThrows(IllegalArgumentException.class, () -> validateBrackets(products1));

        String[] products2 = {"[사이다,1000,10]", "[콜라,1500,5]"};
        assertDoesNotThrow(() -> validateBrackets(products2));
    }

    @Test
    void 개별_상품_대괄호_세미콜론_구분_확인() {
        String[] products1 = {"[사이다,1000,10][콜라,1500,5]"};
        assertThrows(IllegalArgumentException.class, () -> validateProductDivisionBySemicolon(products1));

        String[] products2 = {"[사이다,1000,10]", "[콜라,1500,5]"};
        assertDoesNotThrow(() -> validateProductDivisionBySemicolon(products2));
    }
}