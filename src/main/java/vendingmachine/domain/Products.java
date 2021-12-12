package vendingmachine.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Products {

    private final List<Product> products;

    public Products(List<Product> products) {
        checkProductNameDuplicate(products);
        this.products = products;
    }

    private static void checkProductNameDuplicate(List<Product> products) {
        Set<Product> productSet = new HashSet<>(products);
        if (products.size() != productSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 이름의 상품은 같이 입력될 수 없습니다.");
        }
    }
}
