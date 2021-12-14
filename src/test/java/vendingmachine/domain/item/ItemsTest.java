package vendingmachine.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    void Item객체로_아이템_추가_가능() {
        Items items = new Items();
        String itemName = "item";
        Item item = new Item(itemName, 10000);
        int quantity = 5;
        items.add(item, quantity);

        assertThat(items.findByItemName(itemName).get()).isEqualTo(item);
    }

    @Test
    void 상품_이름으로_검색시_목록에_없는_상품은_빈_아이템_반환() {
        Items items = new Items();
        String notExistItemName = "GHOST";

        assertThat(items.findByItemName(notExistItemName)).isEmpty();
    }

    @Test
    void 상품_이름으로_검색시_목록에_있는_상품은_해당_아이템_반환() {
        Items items = new Items();
        String existItemName = "item";
        Item item = new Item(existItemName, 10000);
        int quantity = 5;
        items.add(item, quantity);

        assertThat(items.findByItemName(existItemName).get()).isEqualTo(item);
    }

    @Test
    void 재고가_0_이상인_것을_확인_가능() {
        Items items = new Items();
        Item item = new Item("item", 10000);
        int quantity = 5;
        items.add(item, quantity);

        assertThat(items.isInStock(item)).isTrue();
    }

    @Test
    void 재고가_0인_것을_확인_가능() {
        Items items = new Items();
        Item item = new Item("item", 10000);
        int quantity = 0;
        items.add(item, quantity);

        assertThat(items.isInStock(item)).isFalse();
    }

    @Test
    void 아이템의_개수_1_감소_가능() {
        Items items = new Items();
        Item item = new Item("item", 10000);
        int quantity = 1;
        items.add(item, quantity);
        items.reduce(item);

        assertThat(items.isInStock(item)).isFalse();
    }

    @Test
    void 재고가_있는_상품_중_가장_낮은_가격을_찾아낼_수_있다() {
        Items items = new Items();
        int targetPrice = 10;
        Item item = new Item("CheapestItem", targetPrice);
        items.add(new Item("itemNotInStock", 0), 0);
        items.add((item), 1);
        items.add(new Item("MoreExpensiveItem", 20), 1);

        assertThat(items.findLowestPriceInStock()).isEqualTo(targetPrice);
    }

    @Test
    void 모든_상품이_재고가_없는_것을_확인() {
        Items items = new Items();
        items.add(new Item("itemNotInStock", 0), 0);
        items.add(new Item("itemMoreExpensive", 15), 0);

        assertThat(items.isEmptyItems()).isTrue();
    }

    @Test
    void 재고가_하나라도_있음을_확인() {
        Items items = new Items();
        items.add(new Item("itemNotInStock", 0), 1);
        items.add(new Item("itemMoreExpensive", 15), 0);

        assertThat(items.isEmptyItems()).isFalse();
    }
}
