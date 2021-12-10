package vendingmachine.domain.machine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {
    private final int balance = 1000;

    @Test
    void 자판기_초기잔액_설정() {
        VendingMachine machine = VendingMachine.of(balance);
        assertThat(machine.isEqualBalance(balance)).isTrue();
    }
}
