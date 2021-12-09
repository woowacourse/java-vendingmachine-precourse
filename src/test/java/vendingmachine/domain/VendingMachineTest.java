package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VendingMachineTest {

    @ParameterizedTest
    @DisplayName("10원 이상 10으로 나눠떨어지는 정상적인 금액을 입력받는다.")
    @ValueSource(ints = {10, 100, 180, 20, 2000, 10000, 40000})
    void 자판기_초기_금액_입력_정상(int inputMoney) {
        //given
        VendingMachine vm = new VendingMachine();

        //when
        //then
        vm.putInitialAmount(inputMoney);
    }

}