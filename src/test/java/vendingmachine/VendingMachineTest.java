package vendingmachine;

import org.junit.jupiter.api.Test;
import vendingmachine.domain.Changes;
import vendingmachine.domain.VendingMachine;

import static org.assertj.core.api.Assertions.*;

class VendingMachineTest {

    @Test
    void 보유금액을_입력받아_무작위로_잔돈을_생성한다() {
        int seedMoney = 3000;
        VendingMachine vendingMachine = new VendingMachine(seedMoney);
        Changes changes = vendingMachine.getChanges();
        assertThat(changes.sum()).isEqualTo(seedMoney);
    }

}
