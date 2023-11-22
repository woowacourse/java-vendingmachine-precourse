package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ProductsTest {

    @ParameterizedTest
    @MethodSource("createProducts")
    void 생성자_테스트(){
        // given
        Map<Product, Integer> products = new HashMap<>();
        // when
        Products result = Products.from(products);
        // then
        assertThat(result).isInstanceOf(Products.class);
    }

    private static Stream<Map<Product, Integer>> createProducts(){
        Map<Product, Integer> test1 = new HashMap<>();
        test1.put(Product.of("사이다", 1000), 1);
        test1.put(Product.of("콜라", 1000), 101);

        return Stream.of(
                new HashMap<>(),
                test1
        );
    }
}