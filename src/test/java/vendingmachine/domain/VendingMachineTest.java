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
        VendingMachine vm = new VendingMachine();
        vm.putInitialAmount(inputMoney);
    }

    @ParameterizedTest
    @DisplayName("초기 금액으로 10원 밑으로 입력받으면 에러를 반환한다.")
    @ValueSource(ints = {9, 6, 0, -1, -10, -100, -87, -240, -900, -10000})
    void 자판기_초기_금액_입력_동전_최소보다_적은_경우_오류() {
        VendingMachine vm = new VendingMachine();
        Assertions.assertThatThrownBy(() -> vm.putInitialAmount(inputMoney)).isInstanceOf(IllegalArgumentException.class); //TODO: 문구는 나중에 생성
    }
}