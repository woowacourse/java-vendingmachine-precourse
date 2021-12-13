package vendingmachine.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void total_계산() {
        Money money = new Money(5000);
        assertEquals(5000, money.getTotalMoney());
    }
}