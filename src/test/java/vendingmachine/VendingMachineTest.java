package vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Changes;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Product coke = new Product("콜라", 1500);
    private Product cider = new Product("사이다", 1500);
    private int seedMoney;

    @BeforeEach
    void setUp() {
        seedMoney = 450;
        vendingMachine = new VendingMachine(seedMoney);
    }

    @Test
    void 보유금액을_입력받아_무작위로_잔돈을_생성한다() {
        Changes changes = vendingMachine.getChanges();
        assertThat(changes.sum()).isEqualTo(seedMoney);
    }

    @Test
    void 상품_금액을_투입하고_상품을_구매한다() {
        int money = 3000;
        vendingMachine.addProduct(coke, 2);
        vendingMachine.inputMoney(money);

        vendingMachine.get(coke);

        Map<Product, Integer> products = vendingMachine.getProducts();

        assertThat(products.get(coke)).isEqualTo(1);
        assertThat(vendingMachine.getInputMoney()).isEqualTo(1500);
    }

    @Test
    void 구입하려는_상품가격이_투입금액보다_크면_예외를_일으킨다() {
        int money = 1400;
        vendingMachine.addProduct(coke, 2);
        vendingMachine.inputMoney(money);

        assertThatThrownBy(() -> vendingMachine.get(coke)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입하려는_상품의_재고가_모자라면_예외를_일으킨다() {
        int money = 3000;
        vendingMachine.addProduct(coke, 1);
        vendingMachine.inputMoney(money);

        vendingMachine.get(coke);

        assertThatThrownBy(() -> vendingMachine.get(coke)).isInstanceOf(IllegalArgumentException.class);
    }
}
