package vendingmachine.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductsTest {
    private static Products products;

    @BeforeAll
    static void initial() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(new String[]{"콜라", "3000", "2"}));
        list.add(new Product(new String[]{"사이다", "2000", "1"}));
        list.add(new Product(new String[]{"환타", "2000", "0"}));

        products = new Products(list);
    }

    @Test
    void 상품_정상_구매() {
        assertThat(products.buyProduct("콜라", 5000)).isTrue();
    }

    @Test
    void 투입금액_부족() {
        assertThat(products.buyProduct("콜라", 1000)).isFalse();
    }

    @Test
    void 존재하지_않는_상품() {
        assertThat(products.buyProduct("유니콘", 5000)).isFalse();
    }
}