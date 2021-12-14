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

    @Test
    void invalidStartBracketTest() {
        validateThrows("콜락,100,3]");
    }

    @Test
    void invalidEndBracketTest() {
        validateThrows("[콜락,100,3");
    }

    @Test
    void noBracketTest() {
        validateThrows("abc,1000,1");
    }

    @Test
    void invalidBracketTest() {
        validateThrows("[abc,2000,1;[bbc,300,1]");
    }

    @Test
    void invalidNameTest() {
        validateThrows("[콜 라,200,5]");
    }

    @Test
    void invalidFieldSizeTest() {
        validateThrows("[코크,20000]");
    }

    @Test
    void invalidNumberTest() {
        validateThrows("[코코,a123,123]");
    }

    @Test
    void invalidFormatTest() {
        validateThrows("[z,100,100];[b,100;,10]");
    }
}
