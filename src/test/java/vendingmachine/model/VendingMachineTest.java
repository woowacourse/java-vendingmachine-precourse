package vendingmachine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    @BeforeEach
    void init() {
        vendingMachine = new VendingMachine("[콜라,1500,20];[사이다,1000,10]", new HoldingCoins(450));
        vendingMachine.insertMoney(5000);
    }

    @Test
    void 자판기_수요_상품이_없을때_예외() {
        assertThatThrownBy(() -> vendingMachine.buy("맥주"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품구매금액_투입금액_초과_예외() {
        vendingMachine = new VendingMachine("[콜라,5500,20];[사이다,1000,10]", new HoldingCoins(450));

        assertThatThrownBy(() -> vendingMachine.buy("콜라"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수요_상품_재고_부족_예외() {
        vendingMachine = new VendingMachine("[콜라,1500,20];[사이다,1000,0]", new HoldingCoins(450));

        assertThatThrownBy(() -> vendingMachine.buy("사이다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최저가격_남은금액_초과하지않음_True() {
        vendingMachine.insertMoney(1000);

        assertThat(vendingMachine.isPurchasable()).isTrue();
    }

    @Test
    void 최저가격_남은금액_초과_False() {
        vendingMachine.insertMoney(999);

        assertThat(vendingMachine.isPurchasable()).isFalse();
    }

    @Test
    void 모든상품_재고_없음_False() {
        vendingMachine = new VendingMachine("[콜라,1500,0];[사이다,1000,0]", new HoldingCoins(450));

        assertThat(vendingMachine.isPurchasable()).isFalse();
    }

    @Test
    void 상품정보_세미콜론으로_구분되지않음_예외() {
        assertThatThrownBy(() -> new VendingMachine("[콜라,1500,10][사이다,1000,10]", new HoldingCoins(450)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세미콜론");
    }

    @Test
    void 상품_구매_수량_차감() {
        vendingMachine.buy("콜라");

        assertThat(vendingMachine.isRestQuantity("콜라", 19)).isTrue();
    }

}
