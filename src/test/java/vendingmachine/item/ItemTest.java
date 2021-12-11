package vendingmachine.item;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.item.Item;

class ItemTest {

    @Test
    void 잔액보다_비싼_상품을_구분() {
        int itemPrice = 1000;
        int lessAmountThanItemPrice = 900;
        Item item = new Item("item", itemPrice);

        assertThat(itemPrice).isGreaterThan(lessAmountThanItemPrice);
        assertThat(item.isMoreExpensiveItemThanMoneyLeft(lessAmountThanItemPrice)).isTrue();
    }

}
