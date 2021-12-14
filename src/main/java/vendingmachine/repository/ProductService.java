package vendingmachine.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductSeller {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_PRODUCT = ERR_HEADER + "존재하지 않는 상품입니다.";
    private static final String ERR_EMPTY_PRODUCTS = ERR_HEADER + "상품 리스트가 비어있습니다.";

    private final Map<String, Product> products;

    public ProductSeller(List<Product> productList) {
        this.products = productList.stream()
            .collect(Collectors.toMap(Product::getName, p -> p));
    }

    public void orderProduct(String name, InputAmount inputAmount) throws IllegalArgumentException {
        validateProductExist(name);
        products.get(name).sell(inputAmount);
    }

    public boolean isEmpty() {
        return this.products.values()
            .stream()
            .allMatch(Product::isEmptyStock);
    }

    public boolean isPurchaseAvailable(InputAmount inputAmount) {
        return !isEmpty() && !getCheapestProduct().isBelowProductPrice(inputAmount);
    }

    private Product getCheapestProduct() throws IllegalArgumentException {
        return products.values().stream()
            .filter(p -> !p.isEmptyStock())
            .min(Comparator.comparingInt(Product::getAmount))
            .orElseThrow(() -> new IllegalArgumentException(ERR_EMPTY_PRODUCTS));
    }

    private void validateProductExist(String name) {
        if (!products.containsKey(name)) {
            throw new IllegalArgumentException(ERR_INVALID_PRODUCT);
        }
    }

    private void validateNonDuplicateName(List<Product> products) {
        if (products.stream()
            .map(Product::getName)
            .distinct()
            .count() != products.size()) {
            throw new IllegalArgumentException(ERR_DUPLICATED_NAME);
        }
    }
}
