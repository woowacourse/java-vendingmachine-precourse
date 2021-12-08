package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachineConsole {
    public CoinBalanceInputValue inputCoinBalance() {
        return new CoinBalanceInputValue(input());
    }

    private String input() {
        return Console.readLine();
    }
}
