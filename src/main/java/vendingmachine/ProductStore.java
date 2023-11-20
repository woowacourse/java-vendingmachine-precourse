package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductStore {
    private static final String PRODUCT_DELIMITER = ";";
    private static final String PRODUCT_REGEX = "^\\[([^,]+),([0-9]+),([0-9]+)\\]$";
    private static final Pattern PRODUCT_PATTERN = Pattern.compile(PRODUCT_REGEX);
    private final Map<Product, Integer> repository;

    public ProductStore() {
        repository = new HashMap<>();
    }

    public void initProductsByString(String input) {
        Arrays.stream(input.split(PRODUCT_DELIMITER))
                .forEach(this::handleProductByString);
    }

    private void handleProductByString(String value) {
        Matcher matcher = PRODUCT_PATTERN.matcher(value);
        if (matcher.find()) {
            String name = matcher.group(1);
            int price = Integer.parseInt(matcher.group(2));
            int quantity = Integer.parseInt(matcher.group(3));
            Product product = new Product(name, price);
            validateQuantity(quantity);
            repository.put(product, quantity);
            return;
        }
        throw new IllegalArgumentException("잘못된 상품 입력입니다.");
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("잘못된 수량입니다.");
        }
    }

    public boolean canBuySomething(int money) {
        return getMinPrice() <= money && getLeftTotalProductCount() > 0;
    }

    public Product findProductByName(String name) {
        return repository.keySet()
                .stream()
                .filter((product) -> product.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
    }

    public void purchaseProduct(Product product) {
        repository.put(product, repository.get(product) - 1);
    }

    private int getMinPrice() {
        return repository.keySet()
                .stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
    }

    private int getLeftTotalProductCount() {
        return repository.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getLeftProductCount(Product product) {
        return repository.get(product);
    }
}
