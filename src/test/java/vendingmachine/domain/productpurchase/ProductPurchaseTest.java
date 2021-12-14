package vendingmachine.domain.productpurchase;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductPurchaseTest {

    @DisplayName("문자열 구매 상품이 주어지고 모든 검증을 통과하면 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"콜라", "사이다"})
    void constructor_InputNameString_Create(String inputProductPurchase) {
        // given & when & then
        assertThatCode(() -> {
            new ProductPurchase(inputProductPurchase);
        }).doesNotThrowAnyException();
    }

    @DisplayName("문자열 구매 상품이 비어있거나 공백이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void constructor_InputNameEmptyOrBlank_ExceptionThrown(String inputProductPurchase) {
        // given & when & then
        assertThatThrownBy(() -> {
            new ProductPurchase(inputProductPurchase);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}