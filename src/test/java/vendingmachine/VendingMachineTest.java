package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;
import vendingmachine.item.Item;
import vendingmachine.item.Items;
import vendingmachine.vendingMachine.VendingMachine;

class VendingMachineTest {

    @Test
    void 남은_금액이_재고가_있는_상품의_최저_가격보다_적으면_구매_불가능_상태_확인() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(10);

        Items items = new Items();
        items.add(new Item("item1", 5), 0);
        items.add(new Item("item2", 15), 1);
        vendingMachine.storeItems(items);
        assertThat(vendingMachine.isPurchaseAvailable()).isFalse();
    }

    @Test
    void 남은_금액이_재고가_있는_상품의_최저_가격보다_많으면_구매_가능_상태_확인() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(10);

        Items items = new Items();
        items.add(new Item("item1", 100), 0);
        items.add(new Item("item2", 5), 1);
        vendingMachine.storeItems(items);
        assertThat(vendingMachine.isPurchaseAvailable()).isTrue();
    }

    @Test
    void 거슬러_준_후_잔여금이_자판기에_남음() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(1000);
        Coins coinBalance = new Coins();
        coinBalance.add(Coin.COIN_50);
        vendingMachine.depositCoinBalance(coinBalance);
        vendingMachine.giveChange();

        assertThat(vendingMachine.showAvailableMoney()).isEqualTo(950);
    }
}
