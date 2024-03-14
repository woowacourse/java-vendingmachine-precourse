package vendingmachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    @Test
    void 사용자로부터_정상적인_보유_금액_입력받기 () {
        // given
        int inputMoney = 500;
        System.setIn(new ByteArrayInputStream(Integer.toString(inputMoney).getBytes()));
        VendingMachine vendingMachine = new VendingMachine();
        // when
        vendingMachine.inputInitialMoney();
        // then
        assertThat(vendingMachine.getCurrentMoney()).isEqualTo(inputMoney);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "111"})
    void 사용자로부터_비정상적인_보유_금액_입력받기(String inputString) {
        // given
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        VendingMachine vendingMachine = new VendingMachine();
        // when, then
        assertThrows(IllegalArgumentException.class, vendingMachine::inputInitialMoney);
    }

    @Test
    void 동전_무작위생성() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        int initialMoneyInputValue = 450;
        System.setIn(new ByteArrayInputStream(Integer.toString(initialMoneyInputValue).getBytes()));
        vendingMachine.inputInitialMoney();
        // when
        vendingMachine.generateInitialCoins();
        //then
        int sumOfCoins = vendingMachine.getCoins().getSumOfCoins();
        int currentMoney = vendingMachine.getCurrentMoney();
        assertThat(sumOfCoins).isEqualTo(currentMoney);
    }

}