package vendingmachine.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vendingmachine.util.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 자판기_문자_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidVendingmachineChange("a100"));
    }

    @Test
    void 자판기_음수_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidVendingmachineChange("-1"));
    }

    @Test
    void 자판기_나눠지지_않는_수_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidVendingmachineChange("11"));
    }

    @Test
    void 자판기_올바른_입력() {
        assertThat(validator.isValidVendingmachineChange("1530"));
    }

    @Test
    void 상품목록_올바른_입력() {
        assertThat(validator.isValidProduct("[사이다,100,3];[콜라,500,10]"));
    }
    @Test
    void 상품목록_상품금액_오류() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidProduct("[콜라,10,5]"));
    }

    @Test
    void 상품목록_괄호_오류() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidProduct("{콜라,100,5}"));
    }

    @Test
    void 상품목록_재고수_오류() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidProduct("[콜라,100,-1]"));
    }

    @Test
    void 상품목록_구분선_오류() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.isValidProduct("[콜라,100,1];"));
    }
}
