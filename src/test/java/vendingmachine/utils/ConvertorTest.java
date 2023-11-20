package vendingmachine.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

class ConvertorTest {

    @Test
    void convertToProducts는_문자열을_상품목록으로_반환한다() {
        // given
        String input = "[콜라,1500,20];[사이다,1000,10]";
        // when&then
        Products products = Convertor.convertToProducts(input);
        assertThat(products).isInstanceOf(Products.class);
        assertThatNoException().isThrownBy(() -> Convertor.convertToProducts(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,,];[사이다,1000,10]", "[사이다,1000,10];[,", " ", "[]", "사이다,1000,10]", "[콜라,1500,,];;[사이다,1000,10]",
            "[콜라,1500,1"})
    void convertToProducts는_상품입력형식이_맞지않으면_실패(String input) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Convertor.convertToProducts(input));
        assertEquals(exception.getMessage(), "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어야 합니다.");
    }

    private static Products createProducts() {
        Map<Product, Integer> test = new HashMap<>();
        test.put(Product.of("콜라", 1500), 20);
        test.put(Product.of("사이다", 1000), 10);
        return Products.from(test);
    }

    @Test
    void splitTest(){
        String input = "[콜라,1500,20]";
        String pattern = "\\[^*.*\\]$";
        System.out.println("TESTTTT"+input.matches(pattern));
    }
}