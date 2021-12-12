package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.model.change.coingenerator.CoinGenerator;
import vendingmachine.model.change.coingenerator.RandomCoinGenerator;
import vendingmachine.view.input.ConsoleInputView;
import vendingmachine.view.input.InputView;
import vendingmachine.view.output.ConsoleOutputView;
import vendingmachine.view.output.OutputView;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Function<Integer, CoinGenerator> coinGeneratingStrategy = RandomCoinGenerator::new;
        VendingMachineController vendingMachineController =
                new VendingMachineController(inputView, outputView, coinGeneratingStrategy);
        vendingMachineController.run();
    }
}
