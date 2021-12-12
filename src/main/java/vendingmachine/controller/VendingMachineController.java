package vendingmachine.controller;

import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.OutputManager;

public class VendingMachineController {
    private VendingMachine vendingMachine;
    private ItemController itemController;
    private InputManager inputManager;

    public boolean checkItemInList(ItemController itemController, String itemName) {
        return itemController.checkInList(itemName);
    }

    public void init() {
        vendingMachine = InputManager.setVendingMachine();
        OutputManager.printVendingMachineStatus(vendingMachine);
        itemController = new ItemController();
        vendingMachine.setRemainderMoney(InputManager.setUserAmount());
    }

    public void processItem(Item item) {
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
            targetItem = itemController.find(InputManager.getWantedItemName());
            processItem(targetItem);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 존재하지 않는 상품입니다.");
        }
        return true;
    }

    public void run() {
        init();
        while(purchase()) {}
    }
}
