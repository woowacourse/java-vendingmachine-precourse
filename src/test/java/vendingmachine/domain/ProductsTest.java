package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProductsTest {

    @Test
    @DisplayName("중복되는 이름의 Product가 입력될 경우 exception이 발생해야 한다.")
    void createProductsExceptionByDuplicateNameTest() {
        // given
        List<Product> input = Arrays.asList(new Product("콜라", 1500, 20),
            new Product("콜라", 1000, 10));

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Products(input))
            .withMessage("[ERROR] 중복되는 이름의 상품은 같이 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("존재하지 않는 이름의 상품을 구매하려는 경우 exception이 발생해야 한다.")
    void purchaseProductExceptionByNotExistProductNameTest() {
        // given
        List<Product> input = Arrays.asList(new Product("콜라", 1500, 20));
        Products products = new Products(input);
        Money money = Money.init();

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> products.purchaseProduct(money, "사이다"))
            .withMessage("[ERROR] 상품의 이름을 찾을 수 없습니다.");
    }

    @Nested
    @DisplayName("Products의 상품 수량이 소진되었는지 확인할 수 있다.")
    class IsExistPurchasableProductTest {

        @Test
        @DisplayName("구매 가능")
        void trueTest() {
            // given
            List<Product> input = Arrays.asList(new Product("콜라", 1500, 20),
                new Product("사이다", 1000, 10));
            Products products = new Products(input);

            // when
            boolean result = products.isExistPurchasableProduct();

            // then
            assertTrue(result);
        }

        @Test
        @DisplayName("구매 불가능")
        void falseTest() {
            // given
            List<Product> input = Arrays.asList(new Product("콜라", 1500, 0),
                new Product("사이다", 1000, 0));
            Products products = new Products(input);

            // when
            boolean result = products.isExistPurchasableProduct();

            // then
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Products의 최소 상품 가격보다 돈이 남았는지 확인할 수 있다.")
    class IsPurchasableMinimumPrice {

        @Test
        @DisplayName("구매 가능")
        void trueTest() {
            // given
            List<Product> input = Arrays.asList(new Product("콜라", 1500, 20),
                new Product("사이다", 1000, 10));
            Products products = new Products(input);
            Money money = Money.valueOf("10000");

            // when
            boolean result = products.isPurchasableMinimumPriceProduct(money);

            // then
            assertTrue(result);
        }

        @Test
        @DisplayName("구매 불가능")
        void falseTest() {
            // given
            List<Product> input = Arrays.asList(new Product("콜라", 1500, 0),
                new Product("사이다", 1000, 0));
            Products products = new Products(input);
            Money money = Money.valueOf("500");

            // when
            boolean result = products.isPurchasableMinimumPriceProduct(money);

            // then
            assertFalse(result);
        }
    }
}