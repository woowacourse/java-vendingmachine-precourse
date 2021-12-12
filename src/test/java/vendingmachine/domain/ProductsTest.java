package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductsTest {

    @Test
    @DisplayName("중복되는 이름의 Product가 입력될 경우 exception이 발생해야 한다.")
    void createProductsExceptionByDuplicateNameTest() {
        // given
        List<Product> input = Arrays.asList(new Product("콜라", 1500, 20),
            new Product("콜라", 1000, 10));

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Products(input))
            .withMessage("[ERROR] 중복되는 이름의 상품은 같이 입력될 수 없습니다.");
    }
}