package vendingmachine;

import vendingmachine.dto.servicedto.ItemsInventoryInfo;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole console = new VendingMachineConsole();

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void on() {
        console.printCurrentBalance(vendingMachineService.createCoinBalance(console.inputCoinBalance()));
        vendingMachineService.createItems(console.inputItemInventoryInfo());
        vendingMachineService.insertMoney(console.inputMoneyToInsert());
        console.printAvailableMoney(vendingMachineService.checkAvailableMoney());
        console.inputItemsToPurchase();
    }

    private ItemsInventoryInfo inputItemsInventoryInfo() {
        return console.inputItemInventoryInfo();
    }
}
