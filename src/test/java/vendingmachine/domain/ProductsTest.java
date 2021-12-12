package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductsTest {

    @DisplayName("Product 리스트가 주어지면 생성된다.")
    @Test
    void constructor_ProductsThenList_Create() {
        // given
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("[콜라,1500,20]");
        Product product2 = new Product("[사이다,1000,10]");

        // when
        products.add(product1);
        products.add(product2);

        // then
        assertThatCode(() -> {
            new Products(products);
        }).doesNotThrowAnyException();
    }

    @DisplayName("존재하는 상품 이름이 주어지면 Optional Product를 반환한다.")
    @Test
    void findByName_ProductNameThenString_OptionalProductReturn() {
        // given
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("[콜라,1500,20]");
        Product product2 = new Product("[사이다,1000,10]");
        productList.add(product1);
        productList.add(product2);
        Products products = new Products(productList);

        String name = "콜라";

        // when
        Product findProduct = products.findByName(name).get();

        // then
        assertThat(findProduct).isEqualTo(product1);
    }
}