package vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.model.Machine;

public class MachineTest {
    private Machine machine = new Machine();

    @Test
    public void test_feat_init_asset() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            machine.setInitialAsset(-12);
        });
        machine.setInitialAsset(16798);
        machine.setInitialAsset(0);
    }
}
