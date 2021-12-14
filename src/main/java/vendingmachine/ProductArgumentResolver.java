package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductArgumentResolver {
    private static final String PRODUCTS_DELIMITER = ";";
    private static final String PRODUCT_DELIMITER = ",";
    private static final String START_PRODUCT = "[";
    private static final String END_PRODUCT = "]";

    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private static final int PRODUCT_LENGTH = 3;

    private final String products;

    public ProductArgumentResolver(String products) {
        this.products = products;
    }

    public List<Product> resolve() {
        return Arrays.stream(splitProducts(this.products))
            .filter(this::isCoveredBrackets)
            .map(this::splitProduct)
            .map(this::newProduct)
            .collect(Collectors.toList());
    }

    private String[] splitProducts(String products) {
        if (products.startsWith(PRODUCT_DELIMITER)) {
            throw ErrorMessage.INVALID_NOT_ALLOW_NAME.getException();
        }

        String[] split = products.split(PRODUCTS_DELIMITER);
        if (countSemicolon(products) != split.length - 1) {
            throw ErrorMessage.INVALID_SEMICOLON.getException();
        }
        return split;
    }

    private long countSemicolon(String products) {
        return products.chars().filter(c -> c == ';').count();
    }

    private boolean isCoveredBrackets(String product) {
        if (product.startsWith(START_PRODUCT) && product.endsWith(END_PRODUCT)) {
            return true;
        }
        throw ErrorMessage.INVALID_BRACKETS.getException();
    }

    private String[] splitProduct(String product) {
        String[] split = product.substring(1, product.length() - 1).split(PRODUCT_DELIMITER);
        if (split.length == PRODUCT_LENGTH) {
            return split;
        }
        throw ErrorMessage.INVALID_DELIMITER.getException();
    }

    private Product newProduct(String[] split) {
        return new Product(split[NAME_INDEX].trim(), toInt(split[PRICE_INDEX]), toInt(split[QUANTITY_INDEX]));
    }

    private int toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            throw ErrorMessage.NOT_NUMBER.getException();
        }
    }
}
