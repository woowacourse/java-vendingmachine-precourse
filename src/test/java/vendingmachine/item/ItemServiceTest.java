package vendingmachine.item;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.dto.ItemDto;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    public static ItemService itemService = ItemService.getInstance();

    @BeforeAll
    public static void beforeAll() {
        itemService.addItem(new ItemDto("사탕", 900, 1));
        itemService.addItem(new ItemDto("젤리", 1500, 3));
    }

    @Test
    public void addTest() {
        assertDoesNotThrow(() -> itemService.addItem(new ItemDto("콜라", 1500, 1)));
        assertThrows(IllegalArgumentException.class, () -> itemService.addItem(new ItemDto("사이다", 90, 20)));
    }

    @Test
    public void orderTest() {
        assertDoesNotThrow(() -> itemService.orderItem("사탕"));
        assertThrows(NotEnoughStockException.class, () -> itemService.orderItem("사탕"));
    }
}