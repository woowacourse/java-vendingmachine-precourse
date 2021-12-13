package vendingmachine.controller;

import static vendingmachine.view.OutputView.*;

import vendingmachine.model.Changes;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.ProductRepository;

public class VendingMachineController {

	private final ViewController viewController;
	private VendingMachine vendingMachine;

	public VendingMachineController(ViewController viewController) {
		this.viewController = viewController;
	}

	public void init() {
		int moneyOfVendingMachine = viewController.returnMoneyOfVendingMachine();
		CoinRepository coinRepository = new CoinRepository(moneyOfVendingMachine);
		coinRepository.init();

		ProductRepository productRepository = new ProductRepository();
		String rawProductsInput = viewController.returnRawProductsInput();
		productRepository.init(rawProductsInput);

		int deposit = viewController.returnDepositAmount();

		this.vendingMachine = new VendingMachine(deposit, productRepository, coinRepository);
	}

	public void run() {
		while (vendingMachine.isContinueToSell()) {
			String productName = viewController.returnProductWantToBuy(vendingMachine);
			sell(productName);

			int remainingDeposit = vendingMachine.getDeposit();
			printRemainingDeposit(remainingDeposit);
		}

		returnChanges();
	}

	private void sell(String productName) {
		ProductRepository productRepository = vendingMachine.getProductList();

		Product product = productRepository.findProduct(productName);
		product.subtractQuantity();

		int price = product.getPrice();
		vendingMachine.subtractDeposit(price);
	}

	private void returnChanges() {
		Changes changes = vendingMachine.createChanges();
		System.out.println(changes);
	}

}
