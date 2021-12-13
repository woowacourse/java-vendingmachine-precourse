package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final String NOT_EXISTED_PRODUCT_MESSAGE = "해당 상품은 존재하지 않습니다.";
    private static final String SEMI_COLON = ";";

    private List<Product> products = new ArrayList<>();

    public Products(String products) {
        addProducts(products);
    }

    public int takeOut(String productName, int productQuantity) {
        Product product = findProduct(productName);
        product.validateEnoughStock(productQuantity);

        return product.getPrice() * productQuantity;
    }

    public boolean isPurchasable(int inputAmount) {
        return isExceedLeastPrice(inputAmount);
    }

    private boolean isExceedLeastPrice(int inputAmount) {
        return products.stream()
                .allMatch(product -> product.isEnoughMoneyToBuy(inputAmount));
    }

    private Product findProduct(String productName) {
        return products.stream()
                .filter(product -> product.isName(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTED_PRODUCT_MESSAGE));
    }

    private void addProducts(String products) {
        for (String productInfo : products.split(SEMI_COLON)) {
            String productInfoWithOutBrackets = removeBrackets(productInfo);
            this.products.add(new Product(productInfoWithOutBrackets));
        }
    }

    private String removeBrackets(String productInfo) {
        return productInfo.substring(1, productInfo.length() - 1);
    }

}