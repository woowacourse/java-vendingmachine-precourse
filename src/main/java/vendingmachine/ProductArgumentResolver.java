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

    private final String products;

    public ProductArgumentResolver(String products) {
        this.products = products;
    }

    public List<Product> resolve() {
        return Arrays.stream(splitProducts(this.products))
                .filter(this::isCoveredBrackets)
                .map(this::splitProduct)
                .map(split -> new Product(split[NAME_INDEX], toInt(PRICE_INDEX, split), toInt(QUANTITY_INDEX, split)))
                .collect(Collectors.toList());
    }

    private String[] splitProducts(String products) {
        return products.split(PRODUCTS_DELIMITER);
    }

    private boolean isCoveredBrackets(String product) {
        if (product.startsWith(START_PRODUCT) && product.endsWith(END_PRODUCT)) {
            return true;
        }
        throw ErrorMessage.INVALID_BRACKETS.getException();
    }

    private String[] splitProduct(String product) {
        return product.substring(1, product.length() - 1).split(PRODUCT_DELIMITER);
    }

    private int toInt(int priceIndex, String[] split) {
        return Integer.parseInt(split[priceIndex]);
    }
}
