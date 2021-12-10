package vendingmachine;

import vendingmachine.dto.ItemsInventoryInfo;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole console = new VendingMachineConsole();

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void on() {
        console.printCurrentBalance(vendingMachineService.createCurrentBalance(console.inputCurrentBalance()));
        vendingMachineService.createItems(console.inputItemInventoryInfo());
    }

    private ItemsInventoryInfo inputItemsInventoryInfo() {
        return console.inputItemInventoryInfo();
    }
}
