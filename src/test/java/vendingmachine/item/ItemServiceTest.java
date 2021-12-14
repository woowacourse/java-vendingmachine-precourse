package vendingmachine.item;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vendingmachine.item.dto.ItemDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    private static ItemService itemService = ItemService.getInstance();

    @BeforeAll
    public static void beforeAll() {
        List<ItemDto> itemDtoList = new ArrayList<>();
        itemDtoList.add(ItemDto.fromInputString("사이다,1000,10"));
        itemDtoList.add(ItemDto.fromInputString("콜라,1200,20"));
        itemDtoList.add(ItemDto.fromInputString("사탕,300,45"));
        itemService.addItems(itemDtoList);
    }

    @Test
    void isNotStockAllItemTest() {
        assertFalse(itemService.isNotStockAllItem());
    }

    @Test
    void getLowestPriceTest() {
        assertEquals(300, itemService.getLowestPrice());
    }
}