package vendingmachine.inputvalue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.assertj.core.api.Assertions;
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

    @Test
    void 상품이_여러개일_때_입력된_문자열을_ItemInventoryList로_변환() {
        String input = "[사이다,1000,10];[콜라,2000,5]";
        String item1Name = "사이다";
        int item1Price = 1000;
        int item1Quantity = 10;
        String item2Name = "콜라";
        int item2Price = 2000;
        int item2Quantity = 5;

        Map<ItemInfo, Integer> itemInventoryInfo = new ItemsInventoryInputValue(input).toItemsInventoryInfo().getInfo();

        assertThat(itemInventoryInfo.size()).isEqualTo(2);
        assertThat(itemInventoryInfo.keySet().stream()).anyMatch(itemInfo -> itemInfo.getName().equals(item1Name) && itemInfo.getPrice() == item1Price && itemInventoryInfo.get(itemInfo) == item1Quantity);
        assertThat(itemInventoryInfo.keySet().stream()).anyMatch(itemInfo -> itemInfo.getName().equals(item2Name) && itemInfo.getPrice() == item2Price && itemInventoryInfo.get(itemInfo) == item2Quantity);
    }

    @Test
    void 상품_가격이_정수로_변환될_수_없으면_예외_발생() {
        String notIntPriceInput = "[사이다,사이다,10]";
        ItemsInventoryInputValue itemsInventoryInputValue = new ItemsInventoryInputValue(notIntPriceInput);

        Assertions.assertThatThrownBy(itemsInventoryInputValue::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_가격이_100원_이상이_아니면_예외_발생() {
        String lessThanTenWonPriceInput = "[사이다,99,10]";
        ItemsInventoryInputValue itemsInventoryInputValue = new ItemsInventoryInputValue(lessThanTenWonPriceInput);

        Assertions.assertThatThrownBy(itemsInventoryInputValue::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_가격이_10원_단위로_나눠_떨어지지_않으면_예외_발생() {
        String notDividingIntoTenPriceInput = "[사이다,113,10]";
        ItemsInventoryInputValue itemsInventoryInputValue = new ItemsInventoryInputValue(notDividingIntoTenPriceInput);

        Assertions.assertThatThrownBy(itemsInventoryInputValue::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품명이_중복이_있으면_예외_발생() {
        String duplicatedNamesInput = "[사이다,1000,10];[사이다,900,8]";
        ItemsInventoryInputValue itemsInventoryInputValue = new ItemsInventoryInputValue(duplicatedNamesInput);

        Assertions.assertThatThrownBy(itemsInventoryInputValue::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수량이_정수로_변환할_수_없으면_예외_발생() {
        String notIntegerQuantity1Input = "[사이다,1000,정수가아닙니다]";
        ItemsInventoryInputValue itemsInventoryInputValue = new ItemsInventoryInputValue(notIntegerQuantity1Input);

        Assertions.assertThatThrownBy(itemsInventoryInputValue::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수량이_1보다_작으면_예외_발생() {
        String lessThanQuantityOf1Input = "[사이다,1000,0]";
        ItemsInventoryInputValue itemsInventoryInputValue = new ItemsInventoryInputValue(lessThanQuantityOf1Input);

        Assertions.assertThatThrownBy(itemsInventoryInputValue::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }
}
