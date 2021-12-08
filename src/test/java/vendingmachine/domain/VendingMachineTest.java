package vendingmachine.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "qwe", "1413"})
    public void 자판기_투입금액_예외테스트 () {
        assertThatThrownBy(() -> new MachineMoney(" ")).isInstanceOf(IllegalArgumentException.class);
    }

}