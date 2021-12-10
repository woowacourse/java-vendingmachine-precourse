package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.ItemsInventoryInfo;
import vendingmachine.dto.request.CurrentBalanceRequest;
import vendingmachine.dto.request.ItemsInventoryRequest;
import vendingmachine.dto.response.CurrentBalanceResponse;

public class VendingMachineConsole {

    public int inputCurrentBalance() {
        int initialCurrentBalance = 0;
        int currentBalance = initialCurrentBalance;
        boolean isInputEntered = false;
        while (!isInputEntered) {
            try {
                currentBalance = new CurrentBalanceRequest(input()).toCurrentBalance();
                isInputEntered = true;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return currentBalance;
    }


    public ItemsInventoryInfo inputItemInventoryInfo() {
        ItemsInventoryInfo itemInventoryInfo = new ItemsInventoryInfo();
        boolean isItemsInventoryInfoEntered = false;
        while (!isItemsInventoryInfoEntered) {
            try {
                itemInventoryInfo = new ItemsInventoryRequest(input()).toItemsInventoryInfo();
                isItemsInventoryInfoEntered = true;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return itemInventoryInfo;
    }

    public void printCurrentBalance(Coins currentBalance) {
        System.out.println(new CurrentBalanceResponse(currentBalance).toPrint());
    }

    private String input() {
        return Console.readLine();
    }
}
