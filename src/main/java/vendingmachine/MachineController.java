package vendingmachine;

public class MachineController {
    private InputView inputView;
    private OutputView outputView;
    private VendingMachine vendingMachine;

    public void run() {
        RemainingCoins coins = generateCoins();
    }

    private RemainingCoins generateCoins() {
        String input = inputView.userInput();
        return new RemainingCoins(input);
    }
}
