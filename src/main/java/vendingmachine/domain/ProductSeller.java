package vendingmachine.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductSeller {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_PRODUCT = ERR_HEADER + "존재하지 않는 상품입니다.";
    private static final String ERR_EMPTY_PRODUCTS = ERR_HEADER + "상품 리스트가 비어있습니다.";

    private final Map<String, Product> products;
    private int minimumProductAmount;

    public ProductSeller(List<String> productInfos) {
        this.products = productInfos.stream()
            .map(Product::getValidProduct)
            .collect(Collectors.toMap(Product::getName, p -> p));
        updateMinimumProductAmount();
    }

    public void pickProduct(String name, InputAmount inputAmount) {
        validateProductExist(name);
        products.get(name).sell(inputAmount);
        updateMinimumProductAmount();
    }

    public boolean isBelowCheapest(InputAmount inputAmount) {
        return this.minimumProductAmount > inputAmount.getAmount();
    }

    private void updateMinimumProductAmount() throws IllegalArgumentException{
        this.minimumProductAmount = products.values().stream()
            .filter(p -> !p.isEmpty())
            .mapToInt(Product::getAmount)
            .min()
            .orElseThrow(() -> new IllegalArgumentException(ERR_EMPTY_PRODUCTS));
    }

    private void validateProductExist(String name) {
        if (!products.containsKey(name)) {
            throw new IllegalArgumentException(ERR_INVALID_PRODUCT);
        }
    }
}
