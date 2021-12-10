package vendingmachine.view;

import org.junit.jupiter.api.Test;
import vendingmachine.util.Validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    @Test
    void 문자_입력_예외_발생() {
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> validator.isValidVendingmachineChange("a100"));
    }

    @Test
    void 음수_입력_예외_발생() {
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> validator.isValidVendingmachineChange("-1"));
    }

    @Test
    void 나눠지지_않는_수_입력_예외_발생() {
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> validator.isValidVendingmachineChange("11"));
    }

    @Test
    void 올바른_입력() {
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> validator.isValidVendingmachineChange("1530"));
    }
}