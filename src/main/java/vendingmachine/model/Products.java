package vendingmachine.model;

import vendingmachine.vo.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {
    public static final String DELIMITER_FOR_PRODUCTS = ";";
    public static final String LEFT_COVER = "[";
    public static final String RIGHT_COVER = "]";
    public static final String DELIMITER_FOR_PRODUCT_DETAILS = ",";
    public static final int INDEX_OF_PRODUCT_NAME = 0;
    public static final int INDEX_OF_PRODUCT_PRICE = 1;
    public static final int INDEX_OF_PRODUCT_QUANTITY = 2;
    private final List<Product> productList;

    public Products(List<Product> productList) {
        this.productList = productList;
    }

    public static Products parseProducts(String input) {
        String[] split = input.split(DELIMITER_FOR_PRODUCTS);
        List<Product> productList = new ArrayList<>();

        Arrays.stream(split).forEach(e -> {
            String[] split1 = e.replace(LEFT_COVER, "")
                                .replace(RIGHT_COVER, "")
                                .split(DELIMITER_FOR_PRODUCT_DETAILS);
            productList.add(
                    new Product(split1[INDEX_OF_PRODUCT_NAME],
                            Integer.parseInt(split1[INDEX_OF_PRODUCT_PRICE]),
                            Integer.parseInt(split1[INDEX_OF_PRODUCT_QUANTITY])));
        });

        return new Products(productList);
    }

    public Product getProductByName(String name) {
        return productList.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .get();
    }

    public boolean isServiceableProduct(String product) {
        return productList.stream()
                .anyMatch(e -> e.getName().equals(product));
    }

    public boolean hasSoldOutProduct() {
        return productList
                .stream()
                .anyMatch(e -> e.getQuantity() < 0);
    }

    public int getLowestPrice() {
        return productList
                .stream()
                .mapToInt(e -> e.getPrice())
                .min()
                .getAsInt();
    }
}
