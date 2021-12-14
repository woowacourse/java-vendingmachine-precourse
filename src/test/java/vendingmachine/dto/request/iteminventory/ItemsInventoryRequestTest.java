package vendingmachine.dto.request.iteminventory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.dto.servicedto.ItemInventoryInfo;

class ItemsInventoryRequestTest {

    @Test
    void 상품이_한_개일때_입력된_문자열을_ItemInventoryInfo로_변환() {
        String name = "사이다";
        int price = 1000;
        int quantity = 10;
        String input = "[" + name + "," + price + "," + quantity + "]";

        List<ItemInventoryInfo> itemsInventoryInfo = new ItemsInventoryRequest(input).toItemsInventoryInfo().getInfo();

        for (ItemInventoryInfo itemInventoryInfo : itemsInventoryInfo) {
            assertThat(itemInventoryInfo.getQuantity()).isEqualTo(quantity);
            assertThat(itemInventoryInfo.getItemInfo().getName()).isEqualTo(name);
            assertThat(itemInventoryInfo.getItemInfo().getPrice()).isEqualTo(price);
        }
    }

    @Test
    void 상품이_여러_개일_때_입력된_문자열을_ItemInventoryList로_변환() {
        String item1Name = "사이다";
        int item1Price = 1000;
        int item1Quantity = 10;
        String item2Name = "콜라";
        int item2Price = 2000;
        int item2Quantity = 5;
        String input = "[" + item1Name + "," + item1Price + "," + item1Quantity + "]" + ";" + "[" + item2Name + "," + item2Price + "," + item2Quantity + "]";

        List<ItemInventoryInfo> itemsInventoryInfo = new ItemsInventoryRequest(input).toItemsInventoryInfo().getInfo();

        assertThat(itemsInventoryInfo.stream()).anyMatch(itemInventoryInfo -> itemInventoryInfo.getQuantity() == item1Quantity && itemInventoryInfo.getItemInfo().getName().equals(item1Name) && itemInventoryInfo.getItemInfo().getPrice() == item1Price);
        assertThat(itemsInventoryInfo.stream()).anyMatch(itemInventoryInfo -> itemInventoryInfo.getQuantity() == item2Quantity && itemInventoryInfo.getItemInfo().getName().equals(item2Name) && itemInventoryInfo.getItemInfo().getPrice() == item2Price);
    }

    @Test
    void 상품_가격이_정수로_변환될_수_없으면_예외_발생() {
        String notIntPriceInput = "[사이다,사이다,10]";
        ItemsInventoryRequest itemsInventoryRequest = new ItemsInventoryRequest(notIntPriceInput);

        Assertions.assertThatThrownBy(itemsInventoryRequest::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_가격이_100원_이상이_아니면_예외_발생() {
        String lessThanTenWonPriceInput = "[사이다,99,10]";
        ItemsInventoryRequest itemsInventoryRequest = new ItemsInventoryRequest(lessThanTenWonPriceInput);

        Assertions.assertThatThrownBy(itemsInventoryRequest::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_가격이_10원_단위로_나눠_떨어지지_않으면_예외_발생() {
        String notDividingIntoTenPriceInput = "[사이다,113,10]";
        ItemsInventoryRequest itemsInventoryRequest = new ItemsInventoryRequest(notDividingIntoTenPriceInput);

        Assertions.assertThatThrownBy(itemsInventoryRequest::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품명이_중복이_있으면_예외_발생() {
        String duplicatedNamesInput = "[사이다,1000,10];[사이다,900,8]";
        ItemsInventoryRequest itemsInventoryRequest = new ItemsInventoryRequest(duplicatedNamesInput);

        Assertions.assertThatThrownBy(itemsInventoryRequest::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수량이_정수로_변환할_수_없으면_예외_발생() {
        String notIntegerQuantity1Input = "[사이다,1000,정수가아닙니다]";
        ItemsInventoryRequest itemsInventoryRequest = new ItemsInventoryRequest(notIntegerQuantity1Input);

        Assertions.assertThatThrownBy(itemsInventoryRequest::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수량이_1보다_작으면_예외_발생() {
        String lessThanQuantityOf1Input = "[사이다,1000,0]";
        ItemsInventoryRequest itemsInventoryRequest = new ItemsInventoryRequest(lessThanQuantityOf1Input);

        Assertions.assertThatThrownBy(itemsInventoryRequest::toItemsInventoryInfo).isInstanceOf(IllegalArgumentException.class);
    }
}
