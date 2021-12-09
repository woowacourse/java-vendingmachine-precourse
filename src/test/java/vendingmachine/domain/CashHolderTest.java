package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashHolderTest {

    @DisplayName("총금액 와 생성된 동전의 금액이 일치하는지 테스트한다")
    @Test
    void totalAmountTest() {
        assertDoesNotThrow(
            () -> new CashHolder(1450)
        );
    }
}