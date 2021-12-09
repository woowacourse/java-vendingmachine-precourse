package vendingmachine;

public class VendingMachineController {
    private final VendingMachineConsole console = new VendingMachineConsole();

    public void on() {
        boolean isAllInputEntered = false;
        while(!isAllInputEntered) {
            try {
                inputCoinBalance();
                isAllInputEntered = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputCoinBalance() {
        return inputCoinBalanceInputValue().toCoinBalance();
    }

    private CoinBalanceInputValue inputCoinBalanceInputValue() {
        return console.inputCoinBalance();
    }
}
