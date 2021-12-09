package vendingmachine.repository;

import java.util.LinkedHashMap;

import vendingmachine.domain.Price;
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

    public boolean has(String productName) {
        return productRepository.containsKey(productName);
    }

    public int takeout(String productName) {
        Product productUserWantBuying = productRepository.get(productName);
        if (productUserWantBuying.hasStock()) {
            productUserWantBuying.takeOutInWarehouse();
        }
        return productUserWantBuying.getPrice();
    }

    //userRepository 돌면서 가장 저렴한 userMoney 를 찾는다.
    //userMoney가 가장 저렴한 제품의 가격보다 적거나,
    public boolean cantBuyBecauseOfNoMoney(Price userMoney) {
        int userPrice = userMoney.getPrice();
        int cheapestPrice = productRepository.keySet()
            .stream()
            .mapToInt(productName -> productRepository.get(productName).getPrice())
            .min()
            .orElseThrow(() -> new IllegalArgumentException("최소값이 없습니다. 로직오류"));
        return userPrice < cheapestPrice; //아무것도 살 수 없는 돈
    }

    public boolean hasNoQuantity() {
        return !productRepository.keySet()
            .stream()
            .anyMatch(productName -> productRepository.get(productName).getQuantity() != 0);
    }
}
