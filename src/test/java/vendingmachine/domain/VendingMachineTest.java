package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class VendingMachineTest {

    @Test
    void randomTest() {
        assertDoesNotThrow(
            () -> new VendingMachine(1450)
        );
    }
}