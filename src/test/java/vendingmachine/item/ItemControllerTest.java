package vendingmachine.item;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vendingmachine.exception.NotEnoughStockException;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    public static ItemController itemController = ItemController.getInstance();

    @BeforeAll
    public static void beforeAll() {
        itemController.addItems("[콜라,1500,1];[사이다,1000,10]");
    }

    @Test
    public void addItemTest() {
        assertDoesNotThrow(() -> itemController.addItems("[젤리,100,3]"));
        assertThrows(IllegalArgumentException.class, () -> itemController.addItems("[사탕,1r4,45]"));
    }

    @Test
    public void purChaseTest() {
        assertDoesNotThrow(() -> itemController.purChaseItem("콜라", 1));
        assertThrows(NotEnoughStockException.class, () -> itemController.purChaseItem("사이다", 11));
    }
}