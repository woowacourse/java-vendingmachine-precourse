package vendingmachine.domain.purchase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseTest {

    @Test
    void 구입_가능한_금액인지_확인() {
        int balance = 1000;
        Purchase purchase = new Purchase(balance);
        int possiblePriceToPurchase = 500;

        Assertions.assertThat(purchase.isAffordablePrice(possiblePriceToPurchase)).isTrue();
    }

    @Test
    void 구입_불가능한_금액인지_확인() {
        int balance = 1000;
        Purchase purchase = new Purchase(balance);
        int impossiblePriceToPurchase = 2000;

        Assertions.assertThat(purchase.isAffordablePrice(impossiblePriceToPurchase)).isFalse();
    }

    @Test
    void 구매_종료시_남은_금액_반환() {
        int balance = 1000;
        Purchase purchase = new Purchase(balance);

        Assertions.assertThat(purchase.end()).isEqualTo(balance);
    }
}
