package vendingmachine.product;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.validator.ProductFormatValidator;

@DisplayName("상품정보의 형식을 테스트한다.")
public class ProductInfoFormatTest {

    void validateThrows(String info) {
        assertThrows(
            IllegalArgumentException.class,
            () -> ProductFormatValidator.validateProductInfo(info)
        );
    }

    @Test
    void invalidStartBracketTest() {
        validateThrows("콜락,100,3]");
        validateThrows("[콜락,100,3");
    }

    @Test
    void invalidEndBracketTest() {
        validateThrows("[콜락,100,3");
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
}
