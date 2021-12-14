package vendingmachine.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.dto.servicedto.ItemInfo;
import vendingmachine.dto.servicedto.ItemInventoryInfo;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;

class ItemFactoryTest {

    @Test
    void 아이템_정보로_아이템을_만들기() {
        String itemName = "itemName";
        ItemsInventoryInfo itemsInventoryInfo = new ItemsInventoryInfo();
        itemsInventoryInfo.add(new ItemInventoryInfo(new ItemInfo(itemName, 1000), 1));

        ItemFactory itemFactory = new ItemFactory();
        Items items = itemFactory.create(itemsInventoryInfo);

        assertThat(items.findByItemName(itemName).get().isRightName(itemName)).isTrue();
    }
}
