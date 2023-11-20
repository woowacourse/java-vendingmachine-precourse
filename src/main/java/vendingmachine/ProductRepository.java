package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductRepository {
    private Map<Product, Integer> repository;

    public ProductRepository() {
        repository = new HashMap<>();
    }

    public void initProductsByString(String input) {
        String regex = "^\\[([^,]+),([0-9]+),([0-9]+)\\]$";

        Pattern pattern = Pattern.compile(regex);


        Arrays.stream(input.split(";"))
                .forEach((value) -> {
                    Matcher matcher = pattern.matcher(value);
                    if (matcher.find()) {
                        String item = matcher.group(1);
                        int price = Integer.parseInt(matcher.group(2));
                        int quantity = Integer.parseInt(matcher.group(3));

                        Product product = new Product(item, price);
                        validateQuantity(quantity);
                        repository.put(product, quantity);
                        return;
                    }
                    throw new IllegalArgumentException("잘못된 상품 입력입니다.");
                });
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("잘못된 수량입니다.");
        }
    }

//    public void addProduct(Product product, int quantity) {
//        repository.put(product, repository.getOrDefault(product, 0) + quantity);
//    }
//
//    private void validate(String input) {
//
//    }

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
