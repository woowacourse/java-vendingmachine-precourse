package vendingmachine.vendingMachine;

import vendingmachine.coin.CoinExchangeMachine;
import vendingmachine.coin.Coins;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;
import vendingmachine.item.ItemFactory;
import vendingmachine.item.Items;
import vendingmachine.vendingMachine.VendingMachine;

public class VendingMachineService {
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
    private final ItemFactory itemFactory = new ItemFactory();
    private VendingMachine vendingMachine;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public Coins createCoinBalance(int coinBalance) {
        return vendingMachine.depositCoinBalance(coinExchangeMachine.changeIntoCoins(coinBalance));
    }

    public Items createItems(ItemsInventoryInfo inputItemInventoryInfo) {
        return vendingMachine.storeItems(itemFactory.createByInventoryList(inputItemInventoryInfo));
    }
}
