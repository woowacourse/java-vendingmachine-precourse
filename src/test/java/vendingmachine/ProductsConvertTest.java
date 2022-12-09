package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.products.Products;
import vendingmachine.util.IntConvert;
import vendingmachine.util.ProductsConvert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ProductsConvertTest {

    private static final String EXCEPTION_MESSAGE = "[ERROR]";

    @DisplayName("잘못된 형식의 입력이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"[사이다,1000,10];[[콜라,1500,20]]", "[]", "[콜라150000]", "[콜라,150000]", "[콜라,15,10,2]",
            "[콜라,백원,20]", "[콜라,100,이십]", "[콜라,백원,이십]", "[사이다,1000,10];[사이다,1500,20]"})
    void InputIsNotNumber(String input) {
        assertThatThrownBy(() -> ProductsConvert.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }
}
