package vendingmachine.controller;

import vendingmachine.service.ProductService;
import vendingmachine.service.PurchaseService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class PurchaseController {
	private final PurchaseService purchaseService;

	public PurchaseController(ProductService productService) {
		purchaseService = new PurchaseService(productService);
	}

	public void inputUserInputAmount() {
		String inputAmount;
		do {
			inputAmount = InputView.inputUserInputAmount();
		} while (!purchaseService.validateInputAmount(inputAmount));
		purchaseService.inputUserInputAmount(inputAmount);
	}

	public int getFinalUserInputAmount() {
		return purchaseService.getUserInputAmount();
	}

	public void buy() {
		while (!purchaseService.shouldReturnChange()) {
			OutputView.printUserInputAmount(purchaseService.userInputAmountToString());
			inputProductToBuy();
			purchaseService.buy();
		}
		OutputView.printUserInputAmount(purchaseService.userInputAmountToString());
	}

	public void inputProductToBuy() {
		String productToBuy;
		do {
			productToBuy = InputView.inputProductToBuy();
		} while (!purchaseService.validateProductToBuy(productToBuy));
	}
}
