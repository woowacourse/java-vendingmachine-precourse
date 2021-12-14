package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
    @Test
    void null_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonValidator.isNull(null, () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }
}
