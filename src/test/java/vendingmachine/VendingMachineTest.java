package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VendingMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 50000})
    void initMoneySuccess(int money) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.initMoney(money);
        });
    }

    @DisplayName("남은 금액이 부족한 경우 구매 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2000, 2999})
    void purchaseProductFailWithLackMoney(int money) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.initMoney(0);

        ProductRepository productRepository = new ProductRepository();
        productRepository.initProductsByString("[콜라,1500,1]");
        vendingMachine.initProducts(productRepository);

        vendingMachine.initInputMoney(money);

        vendingMachine.purchaseProduct("콜라");

        Assertions.assertThatThrownBy(() -> {
            vendingMachine.purchaseProduct("콜라");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품이 소진된 경우 구매 시 예외 발생")
    @Test
    void purchaseProductFailWithQuantity() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.initMoney(0);

        ProductRepository productRepository = new ProductRepository();
        productRepository.initProductsByString("[콜라,1500,1]");
        vendingMachine.initProducts(productRepository);

        vendingMachine.initInputMoney(3000);

        vendingMachine.purchaseProduct("콜라");

        Assertions.assertThatThrownBy(() -> {
            vendingMachine.purchaseProduct("콜라");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
