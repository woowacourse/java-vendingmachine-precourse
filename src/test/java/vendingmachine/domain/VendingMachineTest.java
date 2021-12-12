package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VendingMachineTest {


    @Test
    @DisplayName("Money를 받아 그만큼의 coin을 가지고 있는 자판기를 생성할 수 있다.")
    void createByMoneyTest() {
        // given
        Money money = Money.valueOf("100");
        Coin coin = Coin.valueOfAmount(10);
        VendingMachine vendingMachine = VendingMachine.createByMoney(money, () -> coin);

        Map<Coin, Integer> expected = Coin.createEmptyCoinMap();
        expected.put(coin, expected.get(coin) + 10);

        // when
        Map<Coin, Integer> result = vendingMachine.currentRemainCoins();

        // then
        assertThat(result).isEqualTo(expected);
    }
}