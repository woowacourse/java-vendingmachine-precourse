package vendingmachine;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private VendingMachine vendingMachine;

    public MachineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        RemainingCoins coins = generateCoins();
    }

    private RemainingCoins generateCoins() {
        outputView.printMachineMoneyInputOpening();
        try {
            return new RemainingCoins(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return generateCoins();
        }
    }


}
