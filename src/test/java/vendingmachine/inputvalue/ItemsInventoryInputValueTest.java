package vendingmachine.inputvalue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

import vendingmachine.ItemInfo;

class ItemsInventoryInputValueTest {

    @Test
    void 상품이_한_개일때_입력된_문자열을_ItemInventoryList로_변환() {
        String input = "[사이다,1000,10]";
        String itemName = "사이다";
        int price = 1000;
        int quantity = 10;

        Map<ItemInfo, Integer> itemInventoryList = new ItemsInventoryInputValue(input).toItemsInventoryInfo().getInfo();

        assertThat(itemInventoryList.size()).isEqualTo(1);
        for (ItemInfo itemInfo : itemInventoryList.keySet()) {
            assertThat(itemInfo.getName()).isEqualTo(itemName);
            assertThat(itemInfo.getPrice()).isEqualTo(price);
            assertThat(itemInventoryList.get(itemInfo)).isEqualTo(quantity);
        }
    }
}
