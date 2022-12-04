package vendingmachine.goods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsManagerTest {
    GoodsManager goodsManager;

    @Test
    @DisplayName("투입 금액이 상품 가격보다 적으면 false를 반환한다.")
    void validPurchase() {
        //given
        goodsManager = new GoodsManager("[콜라,1500,20];[사이다,1000,10]");
        String Goods = "콜라";
        int money = 1490;

        //when
        boolean actual = goodsManager.validPurchase(Goods,money);

        //then
        assertFalse(actual);

    }

    @Test
    @DisplayName("투입 가격이 상품의 최소 가격보다 작으면 false를 반환한다.")
    void validMinPurchase() {
        //given
        goodsManager = new GoodsManager("[콜라,1500,20];[사이다,1000,10]");
        int money = 990;

        //when
        boolean actual = goodsManager.validMinPurchase(money);

        //then
        assertFalse(actual);

    }

    @Test
    @DisplayName("상품 구매시, 투입가격에서 상품가격을 제외한만큼 반환된다.")
    void purchaseGoods() {
        //given
        goodsManager = new GoodsManager("[콜라,1500,20];[사이다,1000,10]");
        int money = 1200;
        String goods = "사이다";

        //when
        int actualPrice = goodsManager.purchaseGoods(goods,money);

        //then
        assertEquals(200,actualPrice);

    }
}
