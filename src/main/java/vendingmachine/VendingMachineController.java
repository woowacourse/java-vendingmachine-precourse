package vendingmachine;

import vendingmachine.dto.ItemsInventoryInfo;

public class VendingMachineController {
    private final VendingMachineConsole console = new VendingMachineConsole();

    public void on() {
        boolean isCoinBalanceInputEntered = false;
        while (!isCoinBalanceInputEntered) {
            try {
                inputCoinBalance();
                isCoinBalanceInputEntered = true;
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

    private int inputCoinBalance() {
        return console.inputCoinBalance();
    }

    private ItemsInventoryInfo inputItemsInventoryInfo() {
        return console.inputItemInventoryInfo();
    }
}
