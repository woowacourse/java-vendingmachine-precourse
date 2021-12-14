package vendingmachine.item;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vendingmachine.item.dto.ItemDto;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    private static ItemService itemService = ItemService.getInstance();

    @BeforeAll
    public static void beforeAll() {
        itemService.addItem(ItemDto.fromInputString("사이다,1000,10"));
        itemService.addItem(ItemDto.fromInputString("콜라,1200,20"));
        itemService.addItem(ItemDto.fromInputString("사탕,300,45"));
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