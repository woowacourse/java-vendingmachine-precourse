package vendingmachine.product;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.utils.ProductParser;

@DisplayName("상품정보의 제약사항을 테스트한다")
public class ProductParserTest {

    void validateThrows(String info) {
        assertThrows(
            IllegalArgumentException.class,
            () -> ProductParser.parse(info)
        );
    }

    @Test
    void invalidAmountTest() {
        validateThrows("[사이다,1633,3]");
    }

    @Test
    void minAmountTest() {
        validateThrows("[콜라,98,3]");
    }

    @Test
    void invalidStockTest() {
        validateThrows("[콜라,100,0]");
    }
}
