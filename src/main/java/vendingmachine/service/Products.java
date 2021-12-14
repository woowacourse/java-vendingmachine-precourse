package vendingmachine.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.domain.InputAmount;
import vendingmachine.domain.Product;

public class Products {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_PRODUCT = ERR_HEADER + "존재하지 않는 상품입니다.";
    private static final String ERR_EMPTY_PRODUCTS = ERR_HEADER + "상품 리스트가 비어있습니다.";
    private static final String ERR_DUPLICATED_NAME = ERR_HEADER + "중복된 이름이 있습니다.";

    private final Map<String, Product> products;

    public Products(List<Product> productList) {
        validateNonDuplicateName(productList);
        this.products = productList.stream()
            .collect(Collectors.toMap(Product::getName, p -> p));
    }

    public void orderProduct(String name, InputAmount inputAmount) throws IllegalArgumentException {
        validateProductExist(name);
        products.get(name).sell(inputAmount);
    }

    public boolean isPurchaseAvailable(InputAmount inputAmount) {
        return !this.products.values()
            .stream()
            .allMatch(Product::isSoldOut) && !getCheapestProduct().isBelowProductPrice(inputAmount);
    }

    private Product getCheapestProduct() throws IllegalArgumentException {
        return products.values().stream()
            .filter(p -> !p.isSoldOut())
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
