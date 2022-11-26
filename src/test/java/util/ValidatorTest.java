package util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateProductForm() {
        assertThatThrownBy(() -> Validator.validateProductForm("[d,123,123]")).isInstanceOf(IllegalArgumentException.class);
    }
}