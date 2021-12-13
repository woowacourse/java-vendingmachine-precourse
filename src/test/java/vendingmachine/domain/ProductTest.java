package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ProductTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("상품의 이름이 공백이 들어올 경우 exception이 발생해야 한다.")
    void createProductExceptionByEmptyNameTest(String input) {
        // given
        int price = 100;
        int remainAmount = 20;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Product(input, price, remainAmount))
            .withMessage("[ERROR] 상품의 이름은 공백이 들어올 수 없습니다.");
    }

    @Test
    @DisplayName("제품의 가격이 100원 이하일 경우 exception이 발생해야 한다.")
    void createProductExceptionByLessPriceTest() {
        // given
        String name = "콜라";
        int price = 50;
        int remainAmount = 20;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Product(name, price, remainAmount))
            .withMessage("[ERROR] 상품 가격은 100원 이상의 값이 들어와야 합니다.");
    }

    @Test
    @DisplayName("제품 가격이 10원으로 나누어떨어지지 않을 경우 exception이 발생해야 한다.")
    void createProductExceptionByDivisableCoinTest() {
        // given
        String name = "콜라";
        int price = 1001;
        int remainAmount = 20;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Product(name, price, remainAmount))
            .withMessage("[ERROR] 상품 가격은 10원으로 나누어떨어져야 합니다.");
    }

    @Test
    @DisplayName("상품의 정보가 제한 갯수와 다른 경우 exception이 발생해야 한다.")
    void createProductExceptionByContentSizeTest() {
        // given
        List<String> contents = Arrays.asList("콜라", "1000", "20", "사이다");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Product.crearteProduct(contents))
            .withMessage("[ERROR] 상품은 이름, 가격, 수량을 정확한 포맷으로 입력해야합니다.");
    }

    @Test
    @DisplayName("상품의 이름과 동일한 이름이 들어오는 경우 true를 반환한다.")
    void isEqualsNameTest() {
        // given
        String name = "콜라";
        int price = 1500;
        int remainAmount = 20;
        Product product = new Product(name, price, remainAmount);

        // when
        boolean result = product.isEqualsName(name);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("상품의 남은 수량이 0일 때 구매하려는 경우 exception이 발생해야 한다.")
    void purchaseProductExceptionByNotRemainAmountTest() {
        // given
        String name = "콜라";
        int price = 1500;
        int remainAmount = 0;
        Product product = new Product(name, price, remainAmount);
        Money money = Money.init();

        // when & then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> product.purchaseProduct(money))
            .withMessage("[ERROR] 상품의 수량이 0보다 작은 경우 더이상 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("가격이 현재 금액보다 클 경우 exception이 발생해야 한다.")
    void purchaseProductExceptionByCantPurchaseMoneyTest() {
        // given
        String name = "콜라";
        int price = 1500;
        int remainAmount = 1;
        Product product = new Product(name, price, remainAmount);
        Money money = Money.init();

        // when & then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> product.purchaseProduct(money))
            .withMessage("[ERROR] 현재 돈으로는 구매할 수 없는 상품의 가격입니다.");
    }
}