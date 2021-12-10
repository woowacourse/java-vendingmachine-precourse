package vendingmachine;

import org.assertj.core.api.Assertions;
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
    void 목록에_있는_상품인지_아닌지_구별_가능() {
        Items items = new Items();
        String notExistItemName = "GHOST";

        Assertions.assertThat(items.isOnItemList(notExistItemName)).isFalse();
    }
}
