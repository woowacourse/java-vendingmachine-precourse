package vendingmachine.validator;

import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;

public class InputValidator {
    private static final String ERROR_NOT_ALLOW_UNITS = "1원 단위는 허용되지 않습니다.";
    private static final String ERROR_ONLY_INTEGER = "금액은 숫자만 입력 가능합니다.";
    private static final String ERROR_LESS_THAN_MINIMUM = "투입 금액보다 저렴한 상품이 없습니다.";
    private static final String ERROR_NOT_FOUND_PRODUCT = "입력한 상품이 존재하지 않습니다.";
    private static final String ERROR_NOT_STOCK_PRODUCT = "입력한 상품의 재고가 없습니다.";
    private static final int TENS = 10;
    private static final int ZERO = 0;

    public int isOnlyInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_ONLY_INTEGER);
        }
    }

    public void isMultipleOfTen(int inputInteger) {
        if (inputInteger % TENS != ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_ALLOW_UNITS);
        }
    }

    public void isBiggerThanMinimumPrice(ProductList productList, int money) {
        if (!productList.compareMinimumPrice(money)) {
            throw new IllegalArgumentException(ERROR_LESS_THAN_MINIMUM);
        }
    }

    public Product validateExistedProduct(ProductList productList, String productName) {
        Product product = productList.getProductByName(productName);
        if (product == null) {
            throw new IllegalArgumentException(ERROR_NOT_FOUND_PRODUCT);
        }
        return product;
    }

    public void validateProductIsAvailable(Product product) {
        if (!product.existStock()) {
            throw new IllegalArgumentException(ERROR_NOT_STOCK_PRODUCT);
        }
    }
}
