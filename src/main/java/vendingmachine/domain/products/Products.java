package vendingmachine.domain.products;

import vendingmachine.domain.Money;
import vendingmachine.exception.ProductsDuplicatedNameException;
import vendingmachine.exception.ProductsNotFind;

import java.util.List;

public class Products {

    private final List<Product> products;

    public Products(List<Product> products) {
        validate(products);
        this.products = products;
    }

    public static Products from(List<Product> products) {
        return new Products(products);
    }

    private void validate(List<Product> products) {
        validateDuplicatedName(products);
    }

    private void validateDuplicatedName(List<Product> products) {
        if (products.size() != products.stream().distinct().count()) {
            throw new ProductsDuplicatedNameException();
        }
    }

    public Product findPurchasableProduct(String name, Money money) {
        return products.stream()
                .filter(product -> product.isSameName(name))
                .filter(product -> product.purchasableProduct(money))
                .findAny()
                .orElseThrow(ProductsNotFind::new);
    }

    public Product findMinPriceProduct() {
        return products.stream()
                .reduce(this::compareCheaperPrice)
                .orElseThrow(ProductsNotFind::new);
    }

    private Product compareCheaperPrice(Product p1, Product p2) {
        return p1.CheaperPriceProduct(p2);
    }

    public boolean isAllQuantityZero() {
        return products.stream()
                .allMatch(Product::isSoldOut);
    }
}
