package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Products {

    private final List<Product> products;

    public Products(List<Product> products) {
        checkProductNameDuplicate(products);
        this.products = products;
    }

    public static Products init() {
        return new Products(new ArrayList<>());
    }

    private static void checkProductNameDuplicate(List<Product> products) {
        Set<Product> productSet = new HashSet<>(products);
        if (products.size() != productSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 이름의 상품은 같이 입력될 수 없습니다.");
        }
    }

    public int purchaseProduct(Money money, String name) {
        Product product = getProductByName(name);
        return product.purchaseProduct(money);
    }

    private Product getProductByName(String name) {
        return products.stream()
            .filter(product -> product.isEqualsName(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 상품의 이름을 찾을 수 없습니다."));
    }

    public boolean isExistPurchasableProduct() {
        return products.stream()
            .anyMatch(Product::isPurchasable);
    }

    public boolean isPurchasableMinimumPriceProduct(Money money) {
        Product product = products.stream()
            .min(Comparator.comparingInt(Product::price))
            .orElseThrow(() -> new RuntimeException("[ERROR] 상품의 최소금액이 존재하지 않습니다."));
        return product.isPurchasable(money);
    }
}
