package vendingmachine.domain.product;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.domain.investmentmoney.InvestmentMoney;

public class Products {
    private final List<Product> products;

    public Products(List<Product> products) {
        validateDuplicate(products);
        this.products = products;
    }

    private void validateDuplicate(List<Product> products) {
        int originalSize = products.size();
        Set<String> noneDuplicatedProductNames = products.stream()
            .map(Product::getName)
            .collect(Collectors.toSet());

        if (originalSize != noneDuplicatedProductNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPossiblePurchase(InvestmentMoney investmentMoney) {
        return products.stream()
            .filter(Product::isExistQuantity)
            .anyMatch(investmentMoney::isPay);
    }

    public Optional<Product> findByName(String productPurchaseName) {
        return products.stream()
            .filter(product -> product.isSameName(productPurchaseName))
            .findFirst();
    }
}