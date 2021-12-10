package vendingmachine;

import vendingmachine.dto.ItemsInventoryInfo;

public class VendingMachineController {
    private final VendingMachineConsole console = new VendingMachineConsole();

    public VendingMachineController() {
    }

    public void on() {
        boolean isCurrentBalanceInputEntered = false;
        while (!isCurrentBalanceInputEntered) {
            try {
                inputCurrentBalance();
                isCurrentBalanceInputEntered = true;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        boolean isItemsInventoryInfoEntered = false;
        while (!isItemsInventoryInfoEntered) {
            try {
                inputItemsInventoryInfo();
                isItemsInventoryInfoEntered = true;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private int inputCurrentBalance() {
        return console.inputCurrentBalance();
    }

    private ItemsInventoryInfo inputItemsInventoryInfo() {
        return console.inputItemInventoryInfo();
    }
}
