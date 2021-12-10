package vendingmachine;

import static vendingmachine.StringConstants.PREFIX_OF_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.ItemsInventoryInfo;
import vendingmachine.dto.request.CurrentBalanceRequest;
import vendingmachine.dto.request.ItemsInventoryRequest;
import vendingmachine.dto.request.MoneyToInsertRequest;
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
                printErrorMessage(error.getMessage());
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
                printErrorMessage(error.getMessage());
            }
        }
        return itemInventoryInfo;
    }

    public void printCurrentBalance(Coins currentBalance) {
        System.out.println(new CurrentBalanceResponse(currentBalance).toPrint());
    }

    public int inputMoneyToInsert() {
        int initialMoneyToInsert = 0;
        int moneyToInsert = initialMoneyToInsert;
        boolean isMoneyToInsertEntered = false;
        while (!isMoneyToInsertEntered) {
            try {
                moneyToInsert = new MoneyToInsertRequest(input()).toMoneyToInsert();
                isMoneyToInsertEntered = true;
            } catch (IllegalArgumentException error) {
                printErrorMessage(error.getMessage());
            }
        }
        return moneyToInsert;
    }

    private String input() {
        return Console.readLine();
    }

    private void printErrorMessage(String errorMessage) {
        System.out.print(PREFIX_OF_ERROR_MESSAGE);
        System.out.println(errorMessage);
    }
}
