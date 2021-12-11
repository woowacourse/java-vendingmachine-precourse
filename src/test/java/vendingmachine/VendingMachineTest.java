package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.item.Item;
import vendingmachine.item.Items;

class VendingMachineTest {

    @Test
    void 남은_금액이_재고가_있는_상품의_최저_가격보다_적으면_구매_불가능_상태_확인() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(10);

        Items items = new Items();
        items.add(new Item("item1", 5), 0);
        items.add(new Item("item2", 15), 1);
        vendingMachine.storeItems(items);
        Assertions.assertThat(vendingMachine.isPurchaseAvailable()).isFalse();
    }

    @Test
    void 남은_금액이_재고가_있는_상품의_최저_가격보다_많으면_구매_가능_상태_확인() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(10);

        Items items = new Items();
        items.add(new Item("item1", 100), 0);
        items.add(new Item("item2", 5), 1);
        vendingMachine.storeItems(items);
        Assertions.assertThat(vendingMachine.isPurchaseAvailable()).isTrue();
    }

}
