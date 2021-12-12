package vendingmachine;

import java.util.List;

import vendingmachine.data.VendingMachineData;
import vendingmachine.io.InputHandler;
import vendingmachine.io.OutputHandler;
import vendingmachine.processor.CoinProcessor;
import vendingmachine.processor.ProductProcessor;
import vendingmachine.type.Product;

public class VendingMachine {

	InputHandler inputHandler;
	OutputHandler outputHandler;
	CoinProcessor coinProcessor;
	ProductProcessor productProcessor;

	int balance;

	public VendingMachine(InputHandler inputHandler, OutputHandler outputHandler, CoinProcessor coinProcessor, ProductProcessor productProcessor) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.coinProcessor = coinProcessor;
		this.productProcessor = productProcessor;
	}

	public void start() {
		int vendingMachineMoney = inputHandler.getValidVendingMachineChanges();
		coinProcessor.generateCoinMap(vendingMachineMoney);
		outputHandler.printVendingMachineChanges(coinProcessor.getCoinMap());
		List<Product> productList = inputHandler.getValidProductList();
		productProcessor.setProductList(productList);
		balance = inputHandler.getValidBalance();
		sell();
		outputHandler.printReturnChanges(coinProcessor.generateChangeMap(balance));
	}

	private void sell() {
		while(productProcessor.hasProduct() && productProcessor.isPossibleToBuy(balance)) {
			outputHandler.printBalance(balance);
			Product product = productProcessor.findProduct(inputHandler.getProductName());
			if(!product.isPossibleToBuy(balance)) {
				outputHandler.printMessage(VendingMachineData.BALANCE_NOT_ENOUGH_MESSAGE);
				continue;
			}
			try {
				productProcessor.sellProduct(product);
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
				continue;
			}
			balance -= product.getPrice();
		}
	}
}
