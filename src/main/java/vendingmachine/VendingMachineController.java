package vendingmachine;

import java.io.Console;

import vendingmachine.dto.ItemsInventoryInfo;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole console = new VendingMachineConsole();

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void on() {
        int initialCurrentBalance = 0;
        int currentBalance = initialCurrentBalance;
        boolean isCurrentBalanceInputEntered = false;
        while (!isCurrentBalanceInputEntered) {
            try {
                currentBalance = inputCurrentBalance();
                isCurrentBalanceInputEntered = true;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        console.printCurrentBalance(vendingMachineService.createCurrentBalance(currentBalance));



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
