package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.inputvalue.CoinBalanceInputValue;
import vendingmachine.inputvalue.ItemsInventoryInputValue;

public class VendingMachineConsole {
    public int inputCoinBalance() {
        return new CoinBalanceInputValue(input()).toCoinBalance();
    }

    public ItemsInventoryInfo inputItemInventoryInfo() {
        return new ItemsInventoryInputValue(input()).toItemsInventoryInfo();
    }

    private String input() {
        return Console.readLine();
    }
}
