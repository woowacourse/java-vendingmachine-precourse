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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean isItemsInventoryInfoEntered = false;
        while (!isItemsInventoryInfoEntered) {
            try {
                inputItemsInventoryInfo();
                isItemsInventoryInfoEntered = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
