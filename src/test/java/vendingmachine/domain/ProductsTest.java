package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductsTest {
    @Test
    void 상품구매_테스트_정상() {
        // given
        Set<Product> originalProductSet = new HashSet<>();
        Product originalProduct = new Product("콜라", 1500, 20);
        Product correctResultProduct = new Product("콜라", 1500, 19);
        originalProductSet.add(originalProduct);
        Products originalProducts = new Products(originalProductSet);
        // when
        Products newProducts = originalProducts.buyOne("콜라");
        // then
        assertThat(newProducts.contains(correctResultProduct)).isTrue();
    }

    @Test
    void 상품구매_테스트_소진된상품() {
        // given
        Set<Product> productSet = new HashSet<>();
        Product product = new Product("콜라", 1500, 0);
        productSet.add(product);
        Products products = new Products(productSet);
        // when, then
        assertThrows(IllegalArgumentException.class, () -> products.buyOne("콜라"));
    }

    @Test
    void 상품명_기준으로_특정_상품의_가격_리턴() {
        // given
        Set<Product> productSet = new HashSet<>();
        String productName = "콜라";
        int productCost = 1500;
        Product product = new Product(productName, productCost, 20);
        productSet.add(product);
        Products products = new Products(productSet);
        // when
        int returnedCost = products.getCostByProductName(productName);
        // then
        assertThat(returnedCost).isEqualTo(productCost);
    }

    @Test
    void 상품명_기준으로_특정_상품의_가격_리턴_존재하지않는상품() {
        // given
        Set<Product> productSet = new HashSet<>();
        Product product = new Product("콜라", 1500, 20);
        productSet.add(product);
        Products products = new Products(productSet);
        // when, then
        assertThrows(IllegalArgumentException.class, () -> products.getCostByProductName("닥터페퍼"));
    }

    @Test
    void 모든_상품이_소진되었는지_판단_true() {
        // given
        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product("콜라", 1500, 0));
        productSet.add(new Product("사이다", 2000, 0));
        Products products = new Products(productSet);
        // when, then
        assertThat(products.isSoldOut()).isTrue();
    }

    @Test
    void 모든_상품이_소진되었는지_판단_false_일부소진() {
        // given
        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product("콜라", 1500, 20));
        productSet.add(new Product("사이다", 2000, 0));
        Products products = new Products(productSet);
        // when, then
        assertThat(products.isSoldOut()).isFalse();
    }

    @Test
    void 모든_상품이_소진되었는지_판단_false_소진상품없음() {
        // given
        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product("콜라", 1500, 20));
        productSet.add(new Product("사이다", 2000, 20));
        Products products = new Products(productSet);
        // when, then
        assertThat(products.isSoldOut());
    }

    @Test
    void 상품의_최저_가격_리턴_테스트() {
        // given
        Set<Product> productSet = new HashSet<>();
        Product cheapProduct = new Product("콜라", 1500, 20);
        Product expensiveProduct = new Product("사이다", 2000, 20);
        productSet.add(cheapProduct);
        productSet.add(expensiveProduct);
        Products products = new Products(productSet);
        // when
        int smallestCost = products.getSmallestCost();
        // then
        assertThat(smallestCost).isEqualTo(cheapProduct.getCost());
    }
}