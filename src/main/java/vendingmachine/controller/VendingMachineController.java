package vendingmachine.controller;

import java.util.HashMap;

import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;
import vendingmachine.model.Coin;
import vendingmachine.view.OutputManager;

public class VendingMachineController {
    private VendingMachine vendingMachine;
    private ItemController itemController;
    private InputProcessor inputManager;

    public boolean checkItemInList(ItemController itemController, String itemName) {
        return itemController.checkInList(itemName);
    }

    public void init() {
        vendingMachine = InputProcessor.setVendingMachine();
        OutputManager.printVendingMachineStatus(vendingMachine);
        itemController = new ItemController();
        vendingMachine.setRemainderMoney(InputProcessor.setUserAmount());
    }

    public void buyItem(Item item) {
        if (item.checkPrice(vendingMachine.getRemainderMoney()) && !item.checkNotItem()) {
            vendingMachine.decreaseMoney(item.getPrice());
            item.decreaseCount();
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean purchase() {
        if (itemController.isEmpty() || itemController.checkAmount(vendingMachine.getRemainderMoney())) {
            return false;
        }
        Item targetItem = null;
        try {
            OutputManager.printCurrentUserAmount(vendingMachine);
            targetItem = itemController.find(InputProcessor.getWantedItemName());
            buyItem(targetItem);
        } catch (IllegalArgumentException e) {
            OutputManager.printMessage("[ERROR] 존재하지 않는 상품입니다.");
        }
        return true;
    }


    public void run() {
        init();
        while(purchase()) {}
        HashMap<Coin, Integer> remainderCoinCount = vendingMachine.getRemainderByCoin();
        OutputManager.printCurrentUserAmount(vendingMachine);
        OutputManager.printRemainderCoinCount(remainderCoinCount);
    }
}
