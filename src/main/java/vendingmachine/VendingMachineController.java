package vendingmachine;

public class VendingMachineController {
    private final VendingMachineConsole console = new VendingMachineConsole();

    public void on() {
        inputCoinBalance();
    }

    private int inputCoinBalance() {
        return inputCoinBalanceInputValue().toCoinBalance();
    }

    private CoinBalanceInputValue inputCoinBalanceInputValue() {
        return console.inputCoinBalance();
    }
}
