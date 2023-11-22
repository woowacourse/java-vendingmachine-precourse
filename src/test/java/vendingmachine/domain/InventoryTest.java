package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventoryTest {

    @Test
    @DisplayName("현재 재고 정보를 통해 보유하고 있는 상품의 최저 가격을 얻을 수 있다.")
    public void 최저가격_얻기() {
        //given
        Map<String, Product> stockInfo = new HashMap<>();
        stockInfo.put("콜라", Product.create("콜라", 1000, 20));
        stockInfo.put("펩시", Product.create("펩시", 900, 20));
        stockInfo.put("탐스제로", Product.create("탐스제로", 1200, 20));

        Inventory inventory = new Inventory(stockInfo);

        //when
        int minGoodsPrice = inventory.getMinGoodsPrice();

        //then
        assertThat(minGoodsPrice).isEqualTo(900);
    }
}