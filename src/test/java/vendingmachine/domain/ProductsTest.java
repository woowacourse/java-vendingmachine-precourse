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

    @DisplayName("전체 상품 중 수량이 하나라도 존재하고 구매 가능한 경우 true를 반환한다.")
    @Test
    void isExistTotalQuantity_ExistQuantity_True() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("3000");
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("[콜라,1500,1]");
        Product product2 = new Product("[사이다,1000,0]");
        productList.add(product1);
        productList.add(product2);
        Products products = new Products(productList);

        // when
        boolean result = products.isPossiblePurchase(investmentMoney);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("전체 상품 수량이 하나도 존재하지 않는 경우 false를 반환한다.")
    @Test
    void isExistTotalQuantity_NotExistQuantity_False() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("3000");
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("[콜라,1500,0]");
        Product product2 = new Product("[사이다,1000,0]");
        productList.add(product1);
        productList.add(product2);
        Products products = new Products(productList);

        // when
        boolean result = products.isPossiblePurchase(investmentMoney);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("수량이 존재하는 상품 중 구매 가능한 상품이 없는 경우 false를 반환한다.")
    @Test
    void isPossiblePurchase_ExistQuantityAndNotPayableProduct_False() {
        // given
        InvestmentMoney investmentMoney = new InvestmentMoney("1000");
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("[콜라,1500,1]");
        Product product2 = new Product("[사이다,1000,0]");
        productList.add(product1);
        productList.add(product2);
        Products products = new Products(productList);

        // when
        boolean result = products.isPossiblePurchase(investmentMoney);

        // then
        assertThat(result).isFalse();
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