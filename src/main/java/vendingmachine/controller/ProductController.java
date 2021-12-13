package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.MoneyModel;
import vendingmachine.model.ProductModel;
import vendingmachine.validator.MachineProductsValidator;
import vendingmachine.validator.ProductValidator;
import vendingmachine.view.MoneyView;
import vendingmachine.view.ProductView;

public class ProductController {
	public void inputProduct() {
		ProductView.messageInputProduct();
		ProductModel.enrollProducts(inputProductUntilValid());
	}

	public void orderProduct() {
		MoneyView.printLastUserMoney(MoneyModel.getUserMoney());
		ProductView.messageOrderProduct();
		orderProductNameUntilValid();
	}

	private String inputProductUntilValid() {
		String inputProductLine;
		do {
			inputProductLine = Console.readLine();
		} while (!MachineProductsValidator.checkMachineProducts(inputProductLine));
		return inputProductLine;
	}

	private String orderProductNameUntilValid() {
		String productName;
		do {
			productName = Console.readLine();
		} while (!ProductValidator.checkProductName(productName));
		return productName;
	}
}
