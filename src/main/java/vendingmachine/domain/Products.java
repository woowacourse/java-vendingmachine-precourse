package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import vendingmachine.exception.ProductNameNotFoundException;
import vendingmachine.exception.ProductNotFoundLeastException;
import vendingmachine.exception.ProductsNameDuplicateException;

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
            throw new ProductsNameDuplicateException();
        }
    }

    public void putProducts(List<Product> products) {
        checkProductNameDuplicate(this.products, products);
        this.products.addAll(products);
    }

    private void checkProductNameDuplicate(List<Product> products, List<Product> addProducts) {
        Set<Product> productSet = new HashSet<>(products);
        productSet.addAll(addProducts);
        if (products.size() + addProducts.size() != productSet.size()) {
            throw new ProductsNameDuplicateException();
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
            .orElseThrow(ProductNameNotFoundException::new);
    }

    public boolean isExistPurchasableProduct() {
        return products.stream()
            .anyMatch(Product::isPurchasable);
    }

    public boolean isPurchasableMinimumPriceProduct(Money money) {
        Product product = products.stream()
            .min(Comparator.comparingInt(Product::price))
            .orElseThrow(ProductNotFoundLeastException::new);
        return product.isPurchasable(money);
    }
}
