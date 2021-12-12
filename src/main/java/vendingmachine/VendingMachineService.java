package vendingmachine;

import vendingmachine.coin.CoinExchangeMachine;
import vendingmachine.coin.Coins;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;
import vendingmachine.item.ItemFactory;
import vendingmachine.item.Items;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
    private final ItemFactory itemFactory = new ItemFactory();

    public Coins createCoinBalance(int coinBalance) {
        return vendingMachine.depositCoinBalance(coinExchangeMachine.changeIntoCoins(coinBalance));
    }

    public Items createItems(ItemsInventoryInfo inputItemInventoryInfo) {
        return vendingMachine.storeItems(itemFactory.createByInventoryList(inputItemInventoryInfo));
    }

    public void insertMoney(int money) {
        vendingMachine.insertMoney(money);
    }

    public int checkAvailableMoney() {
        return vendingMachine.showAvailableMoney();
    }

    public void purchaseByItemName(String inputItemsToPurchase) {
        vendingMachine.purchase(inputItemsToPurchase);
    }

    public boolean isPurchaseAvailable() {
        return vendingMachine.isPurchaseAvailable();
    }

    public Coins giveChange() {
        return vendingMachine.giveChange();
    }
}
