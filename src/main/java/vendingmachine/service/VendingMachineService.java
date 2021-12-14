package vendingmachine.service;

import vendingmachine.domain.coin.CoinExchangeMachine;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.item.ItemFactory;
import vendingmachine.domain.vendingMachine.VendingMachine;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;

public class VendingMachineService {
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
    private final ItemFactory itemFactory = new ItemFactory();
    private final VendingMachine vendingMachine;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public Coins createCoinBalance(int coinBalance) {
        return vendingMachine.depositCoinBalance(coinExchangeMachine.changeIntoCoins(coinBalance));
    }

    public void createItems(ItemsInventoryInfo itemsInventoryInfo) {
        vendingMachine.storeItems(itemFactory.create(itemsInventoryInfo));
    }
}
