package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.io.InputHandler;
import vendingmachine.io.OutputHandler;
import vendingmachine.processor.CoinProcessor;
import vendingmachine.processor.ProductProcessor;
import vendingmachine.type.Product;

public class Application {
	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {
		OutputHandler outputHandler = new OutputHandler();
		InputHandler inputHandler = new InputHandler(outputHandler);
		CoinProcessor coinProcessor = new CoinProcessor();
		ProductProcessor productProcessor = new ProductProcessor();
		VendingMachine vendingMachine = new VendingMachine(inputHandler, outputHandler, coinProcessor, productProcessor);
		vendingMachine.start();
	}
}
