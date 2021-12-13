package vendingmachine.domain.product;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import vendingmachine.domain.investmentmoney.InvestmentMoney;

public class Products {
    private static final String VALID_DUPLICATE = "[ERROR] 상품 이름은 중복될 수 없습니다.";

    private final List<Product> products;

    public Products(List<Product> products) {
        validateDuplicate(products);
        this.products = products;
    }

    private void validateDuplicate(List<Product> products) {
        int originalSize = products.size();
        Set<String> noneDuplicatedProductNames = products.stream()
            .map(Product::getName)
            .collect(toSet());

        if (originalSize != noneDuplicatedProductNames.size()) {
            throw new IllegalArgumentException(VALID_DUPLICATE);
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