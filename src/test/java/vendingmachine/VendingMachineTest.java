package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VendingMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 50000})
    void initMoneySuccess(int money) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.initMoney(money);
        });
    }

}
