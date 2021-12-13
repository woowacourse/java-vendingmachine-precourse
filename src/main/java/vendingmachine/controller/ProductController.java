package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.MachineProductsValidator;
import vendingmachine.view.ProductView;

public class ProductController {
	public void inputProduct() {
		ProductView.messageInputProduct();
		inputProductUntilValid();
	}

	private String inputProductUntilValid() {
		String inputProductLine;
		do {
			inputProductLine = Console.readLine();
		} while (!MachineProductsValidator.checkMachineProducts(inputProductLine));
		return inputProductLine;
	}
}
