package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final String NOT_EXISTED_PRODUCT_MESSAGE = "해당 상품은 존재하지 않습니다.";
    private static final String NOT_START_WITH_BRACKET_MESSAGE = "상품 정보는 대괄호로 시작해야합니다.";
    private static final String NOT_END_WITH_BRACKET_MESSAGE = "상품 정보는 대괄호로 끝나야합니다.";
    private static final String SEMI_COLON = ";";
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";

    private List<Product> products = new ArrayList<>();

    public Products(String products) {
        addProducts(products);
    }

    public int takeOut(String productName, int productQuantity) {
        Product product = find(productName);
        product.validateEnoughStock(productQuantity);
        product.decreaseQuantity(productQuantity);

        return product.getPrice() * productQuantity;
    }

    public boolean isPurchasable(int inputAmount) {
        return isExceedLeastPrice(inputAmount) && isAnyProductInStock();
    }

    public Product find(String productName) {
        return products.stream()
                .filter(product -> product.isName(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTED_PRODUCT_MESSAGE));
    }
    private boolean isAnyProductInStock() {
        return products.stream()
                .anyMatch(Product::hasStock);
    }

    private boolean isExceedLeastPrice(int inputAmount) {
        return products.stream()
                .allMatch(product -> product.isEnoughMoneyToBuy(inputAmount));
    }

    private void addProducts(String products) {
        for (String productInfo : products.split(SEMI_COLON)) {
            String productInfoWithOutBrackets = removeBrackets(productInfo);
            this.products.add(new Product(productInfoWithOutBrackets));
        }
    }

    private String removeBrackets(String productInfo) {
        validateProductInfoContainsBracket(productInfo);

        return productInfo.substring(1, productInfo.length() - 1);
    }

    private void validateProductInfoContainsBracket(String productInfo) {
        if (isNotStartWithBracket(productInfo)) {
            throw new IllegalArgumentException(NOT_START_WITH_BRACKET_MESSAGE);
        }
        if (isNotEndWithBracket(productInfo)) {
            throw new IllegalArgumentException(NOT_END_WITH_BRACKET_MESSAGE);
        }
    }

    private boolean isNotEndWithBracket(String productInfo) {
        return !productInfo.startsWith(START_BRACKET);
    }

    private boolean isNotStartWithBracket(String productInfo) {
        return !productInfo.endsWith(END_BRACKET);
    }

}