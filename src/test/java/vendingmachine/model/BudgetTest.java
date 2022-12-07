package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BudgetTest {

    private Product product = Product.from("[콜라,1000,20]");
    private Budget unaffordableBudget = Budget.from(500);
    private Budget affordableBudget = Budget.from(1200);

    @Test
    void 살_수_있음_테스트() {
        Assertions.assertFalse(unaffordableBudget.isAffordable(product));
        Assertions.assertTrue(affordableBudget.isAffordable(product));
    }

    @Test
    void 구매_테스트() {
        affordableBudget.buy(product);
        Assertions.assertEquals(200, affordableBudget.getLeftMoney());
    }

    @Test
    void 예산_부족_테스트() {
        Assertions.assertTrue(unaffordableBudget.hasTooLittleBudget(product.getProductPrice()));
    }
}