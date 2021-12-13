package vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    @BeforeEach
    void init() {
        vendingMachine = new VendingMachine("[콜라,1500,20];[사이다,1000,10]", 450);
        vendingMachine.insertMoney(5000);
    }

    @Test
    void 자판기_수요_상품이_없을때_예외() {
        assertThatThrownBy(() -> vendingMachine.buy("맥주", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품구매금액_투입금액_초과_예외() {
        assertThatThrownBy(() -> vendingMachine.buy("콜라", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
