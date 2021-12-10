package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    void Item객체로_아이템_추가_가능() {
        Items items = new Items();
        Item item = new Item("item1", 10000);
        int quantity = 5;
        items.addItem(item, quantity);

        Assertions.assertThat(items.countItems(item)).isEqualTo(quantity);
    }

    @Test
    void 상품_이름으로_검색시_목록에_없는_상품은_빈_아이템_반환() {
        Items items = new Items();
        String notExistItemName = "GHOST";

        Assertions.assertThat(items.findByItemByItemName(notExistItemName)).isEmpty();
    }

    @Test
    void 상품_이름으로_검색시_목록에_있는_상품은_해당_아이템_반환() {
        Items items = new Items();
        Item item = new Item("item1", 10000);
        int quantity = 5;
        items.addItem(item, quantity);
        String existItemName = "item1";

        Assertions.assertThat(items.findByItemByItemName(existItemName).get().getName()).isEqualTo(existItemName);
    }
}
