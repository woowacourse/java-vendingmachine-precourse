package vendingmachine;

import vendingmachine.dto.ItemsInventoryInfo;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
    private final ItemFactory itemFactory = new ItemFactory();

    public Coins createCurrentBalance(int currentBalance) {
        return vendingMachine.depositCurrentBalance(coinExchangeMachine.changeIntoCoins(currentBalance));
    }

    public Items createItems(ItemsInventoryInfo inputItemInventoryInfo) {
        return vendingMachine.storeItems(itemFactory.createByInventoryList(inputItemInventoryInfo));
    }
}
