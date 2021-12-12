package vendingmachine.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductSeller {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_PRODUCT = ERR_HEADER + "존재하지 않는 상품입니다.";

    private final Map<String, Product> products;

    public ProductSeller(List<String> productInfos) {
        this.products = productInfos.stream()
            .map(Product::getValidProduct)
            .collect(Collectors.toMap(Product::getName, p -> p));
    }

    public void pickProduct(String name, InputAmount inputAmount) {
        validateProductExist(name);
        products.get(name).sell(inputAmount);
    }

    private void validateProductExist(String name) {
        if (!products.containsKey(name)) {
            throw new IllegalArgumentException(ERR_INVALID_PRODUCT);
        }
    }
}
