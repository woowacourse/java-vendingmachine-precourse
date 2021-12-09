package vendingmachine.repository;

import java.util.LinkedHashMap;

import vendingmachine.domain.Product;

public class ProductRepository {
    LinkedHashMap<String, Product> productRepository = new LinkedHashMap<>(); // String key는 상품의 이름이다.

    public void add(Product product) {
        validateAlreadyHave(product);
        productRepository.put(product.getName(), product);
    }

    private void validateAlreadyHave(Product product) {
        if (productRepository.containsKey(product.getName())) {
            throw new IllegalArgumentException("같은 상품을 여러 번 입력할 수 없습니다.");
        }
    }

    public void showProductRepository() {
        for (String key : productRepository.keySet()) {
            System.out.println(key + ": " + productRepository.get(key));
        }
    }
}
