package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.inputvalue.CoinBalanceInputValue;
import vendingmachine.inputvalue.ItemsInventoryInputValue;

public class VendingMachineConsole {
    public CoinBalanceInputValue inputCoinBalance() {
        return new CoinBalanceInputValue(input());
    }

    public ItemsInventoryInputValue inputItemInventoryList() {
        return new ItemsInventoryInputValue(input());
    }

    private String input() {
        return Console.readLine();
    }
}
