package vendingmachine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductRepositoryTest {
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]"})
    void initProductsByStringSuccess(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            ProductRepository.initProductsByString(input);
        });
    }

    @DisplayName("상품 구분자 형식이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20] [사이다,1000,10]", "[콜라,1500,20].[사이다,1000,10]", "[콜라,1500,20];(사이다,1000,10)"})
    void initProductsByStringFailWithInvalidDelimiter(String input) {
        Assertions.assertThatThrownBy(() -> {
            ProductRepository.initProductsByString(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 입력 타입이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,a];[사이다,1000,10]", "[사이다,a,10]", "[,,10]", "[사이다,,10]", "[사이다,10]"})
    void initProductsByStringFailWithInvalidType(String input) {
        Assertions.assertThatThrownBy(() -> {
            ProductRepository.initProductsByString(input);
        }).isInstanceOf(IllegalArgumentException.class);
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
