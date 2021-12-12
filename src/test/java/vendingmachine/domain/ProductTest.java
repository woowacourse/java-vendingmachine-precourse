package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상품 정보를 검증한다.")
class ProductTest {

    void validateThrows(String info) {
        assertThrows(
            IllegalArgumentException.class,
            () -> Product.getValidProduct(info)
        );
    }

    @Test
    void validateBrackets() {
        validateThrows("콜락,100,3]");
        validateThrows("[콜락,100,3");
    }

    @Test
    void validatePrice() {
        validateThrows("[사이다,1633,3");
    }

    @Test
    void validateMinPrice() {
        validateThrows("[콜라,98,3]");
    }

    @Test
    void validateStock() {
        validateThrows("[콜라,100,0]");
    }

    @Test
    void validateName() {
        validateThrows("[콜 라,200,5]");
    }
}