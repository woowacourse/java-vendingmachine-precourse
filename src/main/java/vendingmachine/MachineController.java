package vendingmachine;

public class MachineController {
    private InputView inputView;
    private OutputView outputView;
    private VendingMachine vendingMachine;

    public void run() {
        RemainingCoins coins = generateCoins();
    }

    private RemainingCoins generateCoins() {
        try {
            return new RemainingCoins(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            generateCoins();
        }
        return null; // ?? 이거 우째
    }


}
