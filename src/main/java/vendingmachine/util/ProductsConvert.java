package vendingmachine.util;

import vendingmachine.domain.products.Price;
import vendingmachine.domain.products.Product;
import vendingmachine.domain.products.Products;
import vendingmachine.domain.products.Quantity;
import vendingmachine.exception.ProductsConvertException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductsConvert {

    private static final String PRODUCTS_DELIMITER = ";";
    private static final String PRODUCTS_DUPLICATED_DELIMITER_REGEX = ";+";
    private static final String PRODUCT_DELIMITER = ",";
    private static final String PRODUCT_DUPLICATED_DELIMITER_REGEX = ",+";
    private static final String PRODUCT_START_END_REGEX = "^\\[|\\]$";
    private static final String BLANK = "";
    private static final int NAME = 0;
    private static final int PRICE = 1;
    private static final int QUANTITY = 2;

    public static Products convert(String input) {
        String[] products = input.replaceAll(PRODUCTS_DUPLICATED_DELIMITER_REGEX, PRODUCTS_DELIMITER)
                .split(PRODUCTS_DELIMITER);

        return Products.from(Arrays.stream(products)
                .map(ProductsConvert::makeProduct)
                .collect(Collectors.toList()));
    }

    private static Product makeProduct(String product) {
        String[] contents = product.replaceAll(PRODUCT_START_END_REGEX, BLANK)
                .replaceAll(PRODUCT_DUPLICATED_DELIMITER_REGEX, PRODUCT_DELIMITER)
                .split(PRODUCT_DELIMITER);

        if (contents.length != 3) {
            throw new ProductsConvertException();
        }

        return new Product(contents[NAME],
                Price.from(IntConvert.convert(contents[PRICE])),
                Quantity.from(IntConvert.convert(contents[QUANTITY])));
    }
}
