package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

class VendingMachineTest {

    @Test
    void isAllPriceGreaterThan_True() {
        // given
        Product coke = new Product("콜라", 1500, 20);
        Product sprite = new Product("사이다", 2000, 10);
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(coke);
        vendingMachine.addProduct(sprite);

        // when, then
        Assertions.assertThat(vendingMachine.isAllPriceGreaterThan(1000)).isTrue();
    }

    @Test
    void isAllProductSoldOut_True() {
        // given
        Product coke = new Product("콜라", 1500, 0);
        Product sprite = new Product("사이다", 2000, 0);
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(coke);
        vendingMachine.addProduct(sprite);

        // when, then
        Assertions.assertThat(vendingMachine.isAllProductSoldOut()).isTrue();
    }
}
