package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.ItemsInventoryInfo;
import vendingmachine.dto.request.CoinBalanceRequest;
import vendingmachine.dto.request.ItemsInventoryRequest;

public class VendingMachineConsole {
    public int inputCoinBalance() {
        return new CoinBalanceRequest(input()).toCoinBalance();
    }

    public ItemsInventoryInfo inputItemInventoryInfo() {
        return new ItemsInventoryRequest(input()).toItemsInventoryInfo();
    }

    private String input() {
        return Console.readLine();
    }
}
