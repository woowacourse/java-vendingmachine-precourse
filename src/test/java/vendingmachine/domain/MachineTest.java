package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.Coin;

import java.util.Map;

class MachineTest {

    private final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    Machine machine;

    @BeforeEach
    private void initMachine() {
        machine = new Machine(1000);
        machine.storeCash(3000);
        machine.storeProduct(new Product("사이다", 3000, 1));
        machine.storeProduct(new Product("콜라", 2000, 1));
        machine.storeProduct(new Product("비싼거", 5000, 1));
    }

    @Test
    @DisplayName("잔여금액이 상품 최저가보다 적으면 isExhausted true")
    void remainCashIsLessThanMinProductAmount() {
        machine.purchase("콜라");
        Assertions.assertTrue(machine.isExhausted());
    }

    @Test
    @DisplayName("상품이 모두 소진되면 isExhausted true")
    void exhaustedAllProduct() {
        machine.storeCash(10000);
        machine.purchase("콜라");
        machine.purchase("사이다");
        machine.purchase("비싼거");
        Assertions.assertTrue(machine.isExhausted());
    }


    @Test
    @DisplayName("존재하지 않는 상품일 경우 예외")
    void purchaseNotExistProduct() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            machine.purchase("뽕따");
        });

        String message = exception.getMessage();
        Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
    }

    @Test
    @DisplayName("잔여금액보다 비싼 상품을 구입하면 예외")
    void buyExpansiveProduct() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            machine.purchase("비싼거");
        });

        String message = exception.getMessage();
        Assertions.assertTrue(message.contains(EXCEPTION_MESSAGE_PREFIX));
    }

    @Test
    @DisplayName("잔돈은 현재 금액보다 적거나 같은 결과를 반환한다.")
    void testGetExchangeMethod() {
        int exchange = 3000;
        Machine machine1 = new Machine(exchange);

        Map<Coin, Integer> exchangeResult = machine.getExchangeResult();
        System.out.println(exchangeResult);

        int totalPrice = 0;
        for (Map.Entry<Coin, Integer> entry : exchangeResult.entrySet()) {
            Coin key = entry.getKey();
            Integer count = entry.getValue();
            totalPrice += key.getAmount() * count;
        }

        Assertions.assertTrue(totalPrice <= exchange);
    }

}