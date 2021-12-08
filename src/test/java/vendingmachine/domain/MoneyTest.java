package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest extends DomainTest {

    @DisplayName("실패_투입금액이 숫자가 아님")
    @Test
    void moneyNotNumber_false() {
        assertThrows(IllegalArgumentException.class, () -> vendingMachine.createMoney("금액"));
    }

    @DisplayName("실패_투입금액이 10으로 안나눠짐")
    @Test
    void moneyNotDivideByTen_false() {
        assertThrows(IllegalArgumentException.class, () -> vendingMachine.createMoney("1111"));
    }

    @DisplayName("실패_투입금액이 최소 상품 금액보다 낮음")
    @Test
    void moneyNotEnough_false() {
        vendingMachine.addBeverage("[콜라,2000,10]");
        assertThrows(IllegalArgumentException.class, () -> vendingMachine.createMoney("1000"));
    }

    @DisplayName("성공_투입금액 투입 성공")
    @Test
    void createMoney_true() {
        vendingMachine.addBeverage("[콜라,2000,10]");
        vendingMachine.createMoney("3000");
        Money money = vendingMachine.getMoney();

        Assertions.assertThat(money.getPrice()).isEqualTo(3000);
    }
}
