package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.ItemsInventoryInfo;
import vendingmachine.dto.request.CurrentBalanceRequest;
import vendingmachine.dto.request.ItemsInventoryRequest;
import vendingmachine.dto.response.CurrentBalanceResponse;

public class VendingMachineConsole {
    public int inputCurrentBalance() {
        return new CurrentBalanceRequest(input()).toCurrentBalance();
    }

    public ItemsInventoryInfo inputItemInventoryInfo() {
        return new ItemsInventoryRequest(input()).toItemsInventoryInfo();
    }

    public void printCurrentBalance(Coins currentBalance) {
        System.out.println(new CurrentBalanceResponse(currentBalance).toPrint());
    }

    private String input() {
        return Console.readLine();
    }
}
