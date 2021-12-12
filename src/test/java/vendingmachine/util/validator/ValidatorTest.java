package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    @Test
    void null_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isNull(null, () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }
}
