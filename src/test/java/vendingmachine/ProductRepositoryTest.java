package vendingmachine;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductRepositoryTest {
    ProductStore repository;

    @BeforeEach
    void setUp() {
        repository = new ProductStore();
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]"})
    void initProductsByStringSuccess(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            repository.initProductsByString(input);
        });
    }

    @DisplayName("상품 구분자 형식이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20] [사이다,1000,10]", "[콜라,1500,20].[사이다,1000,10]", "[콜라,1500,20];(사이다,1000,10)"})
    void initProductsByStringFailWithInvalidDelimiter(String input) {
        Assertions.assertThatThrownBy(() -> {
            repository.initProductsByString(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 입력 타입이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,a];[사이다,1000,10]", "[사이다,a,10]", "[,,10]", "[사이다,,10]", "[사이다,10]"})
    void initProductsByStringFailWithInvalidType(String input) {
        Assertions.assertThatThrownBy(() -> {
            repository.initProductsByString(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1501,20]", "[콜라,15,20]", "[콜라, ,20]", "[콜라,-10,20]"})
    void initProductsByStringFailWithInvalidMoney(String input) {
        Assertions.assertThatThrownBy(() -> {
            repository.initProductsByString(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 구매 가능 여부 확인")
    @ParameterizedTest
    @MethodSource("canBuySomethingProvider")
    void canBuySomething(int leftMoney, boolean expected) {
        ProductStore repository = new ProductStore();
        repository.initProductsByString("[콜라,1500,20];[사이다,1000,10]");
        Assertions.assertThat(repository.canBuySomething(leftMoney)).isEqualTo(expected);
    }

    static Stream<Arguments> canBuySomethingProvider() {
        return Stream.of(
                Arguments.of(1000, true),
                Arguments.of(1500, true),
                Arguments.of(2000, true),
                Arguments.of(500, false),
                Arguments.of(0, false)
        );
    }

//    @Test
//    void t() {
//        String input = "[콜라,1500,20]";
//        String regex = "\\[([^,]+),([0-9]+),([0-9]+)\\]";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//
//        if (matcher.matches()) {
//            String item = matcher.group(1);
//            String price = matcher.group(2);
//            String quantity = matcher.group(3);
//
//            System.out.println("상품: " + item);
//            System.out.println("가격: " + price);
//            System.out.println("수량: " + quantity);
//        } else {
//            System.out.println("일치하는 패턴이 없습니다.");
//        }
//    }

}
