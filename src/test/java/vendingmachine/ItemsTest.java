package vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.dto.ItemInfo;
import vendingmachine.dto.ItemInventoryInfo;
import vendingmachine.dto.ItemsInventoryInfo;

class ItemsTest {

    @Test
    void Item객체로_아이템_추가_가능() {
        Items items = new Items();
        Item item = new Item("item1", 10000);
        int quantity = 5;
        items.addItem(item, quantity);

        Assertions.assertThat(items.countItems(item)).isEqualTo(quantity);
    }
}
