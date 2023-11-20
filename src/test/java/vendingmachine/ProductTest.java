package vendingmachine;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductTest {

    @DisplayName("상품 등록에 성공하는 경우")
    @ParameterizedTest
    @MethodSource("productSuccessProvider")
    void productSuccess(String name, int price) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            new Product(name, price);
        });
    }

    static Stream<Arguments> productSuccessProvider() {
        return Stream.of(
                Arguments.of("asd", 100),
                Arguments.of("콜라", 1000),
                Arguments.of("사이다", 2000)
        );
    }

    @DisplayName("상품 등록에 실패하는 경우")
    @ParameterizedTest
    @MethodSource("productFailProvider")
    void productFail(String name, int price) {
        Assertions.assertThatThrownBy(() -> {
            new Product(name, price);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> productFailProvider() {
        return Stream.of(
                Arguments.of("", 100),
                Arguments.of("콜라", 0),
                Arguments.of("사이다", -99),
                Arguments.of("사이다", 99),
                Arguments.of("사이다", 101)
        );
    }
}
