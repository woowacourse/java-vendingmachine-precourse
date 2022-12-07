package vendingmachine.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.model.Product;
import vendingmachine.util.ExceptionMessage;

class ProductValidatorTest {

    private ProductValidator productValidator;

    @BeforeEach
    void setUp() {
        productValidator = new ProductValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("상품 가격이 100원 미만인 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"[콜라,90,20]", "[콜라,10,20]"})
        void 상품_가격이_100원_미만(String input) {
            assertThatThrownBy(() -> productValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_PRODUCT_PRICE_RANGE.getMessage());
        }


        @DisplayName("상품 가격이 10원으로 나누어 떨어지지 않는 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"[콜라,1001,20]", "[콜라,101,20]", "[콜라,222,20]"})
        void 상품_가격이_10원으로_나누어_떨어지지_않음(String input) {
            assertThatThrownBy(() -> productValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_UNIT.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"[콜라,1500,20]", "[사이다,1000,10]"})
        void 정상_입력(String input) {
            assertThatCode(() -> productValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }


}