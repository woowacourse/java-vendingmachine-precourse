package vendingmachine.domain.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductTest {

    @DisplayName("문자열 상품이 주어지고 모든 검증을 통과하면 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20]", "[사이다,1000,10]"})
    void constructor_InputProductString_Create(String inputProduct) {
        // given & when & then
        assertThatCode(() -> {
            new Product(inputProduct);
        }).doesNotThrowAnyException();
    }

    @DisplayName("입력 상품이 '['로 시작하지 않고 ']'로 끝나지 않는 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20", "사이다,1000,10]", "콜라,1500,20", "", " "})
    void constructor_ValidateStartWithAndEndWithFalse_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 이름이 비어있거나 공백인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[,1500,20]", "[ ,1000,10]"})
    void constructor_ProductNameEmptyOrBlank_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 정수가 아닌 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,150a,20]", "[사이다,abc,10]"})
    void constructor_ProductPriceNotNumberFormat_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 100원 미만인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,50,20]", "[사이다,99,10]"})
    void constructor_ProductPriceLessThen100_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 10으로 나누어 떨어지지 않는 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1515,20]", "[사이다,1111,10]"})
    void constructor_ProductPriceDivided10_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 수량이 정수가 아닌 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,2a]", "[사이다,1000,aa]"})
    void constructor_ProductQuantityNotNumberFormat_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 수량이 0개 이하인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,-1]", "[사이다,1000,0]"})
    void constructor_ProductQuantityNotMoreThan0_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품과 상품 구매를 위한 이름이 같으면 true를 반환한다.")
    @Test
    void isSameName_productPurchaseNameEquals_True() {
        // given
        Product product = new Product("[콜라,1500,1]");
        String productPurchaseName = "콜라";

        // then
        boolean result = product.isSameName(productPurchaseName);

        // when
        assertThat(result).isTrue();
    }

    @DisplayName("상품과 상품 구매를 위한 이름이 다르면 False를 반환한다.")
    @Test
    void isSameName_productPurchaseNameNotEquals_False() {
        // given
        Product product = new Product("[콜라,1500,1]");
        String productPurchaseName = "사이다";

        // then
        boolean result = product.isSameName(productPurchaseName);

        // when
        assertThat(result).isFalse();
    }

    @DisplayName("상품 수량이 부족한 경우 예외를 던진다.")
    @Test
    void receive_QuantityNotExist_ExceptionThrown() {
        // given
        Product product = new Product("[콜라,1500,1]");

        // when
        product.receive();

        // then
        assertThatThrownBy(() -> {
            product.receive();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품의 수량이 0 초과인 경우 true를 반환한다.")
    @Test
    void isExistQuantity_QuantityGraterThan0_True() {
        // given
        Product product = new Product("[콜라,1500,1]");

        // then
        boolean result = product.isExistQuantity();

        // when
        assertThat(result).isTrue();
    }

    @DisplayName("상품의 수량이 0 이하인 경우 False를 반환한다.")
    @Test
    void isExistQuantity_QuantityNotMoreThan0_False() {
        // given
        Product product = new Product("[콜라,1500,1]");
        product.receive();

        // then
        boolean result = product.isExistQuantity();

        // when
        assertThat(result).isFalse();
    }
}