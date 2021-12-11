package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductTest {

    @DisplayName("문자열 상품이 주어지고 모든 검증을 통과하면 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20]", "[사이다,1000,10]"})
    void constructor_InputProductThenString_Create(String inputProduct) {
        // given & when & then
        assertThatCode(() -> {
            new Product(inputProduct);
        }).doesNotThrowAnyException();
    }

    @DisplayName("입력 상품이 '['로 시작하지 않고 ']'로 끝나지 않는 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20", "사이다,1000,10]", "콜라,1500,20", "", " "})
    void constructor_ValidateStartWithAndEndWithThenFalse_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 이름이 비어있거나 공백인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[,1500,20]", "[ ,1000,10]"})
    void constructor_ProductNameThenEmptyOrBlank_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 정수가 아닌 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,150a,20]", "[사이다,abc,10]"})
    void constructor_ProductPriceThenNotNumberFormat_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 100원 미만인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,50,20]", "[사이다,99,10]"})
    void constructor_ProductPriceThenLessThen100_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 10으로 나누어 떨어지지 않는 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1515,20]", "[사이다,1111,10]"})
    void constructor_ProductPriceThenDivided10_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 수량이 정수가 아닌 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,2a]", "[사이다,1000,aa]"})
    void constructor_ProductQuantityThenNotNumberFormat_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 수량이 음수인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,-1]", "[사이다,1000,-10]"})
    void constructor_ProductQuantityThenNegativeNumber_ExceptionThrown(String inputProduct) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Product(inputProduct);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}