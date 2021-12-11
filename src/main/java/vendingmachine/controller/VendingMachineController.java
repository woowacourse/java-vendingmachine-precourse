package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.InputValidator;
import vendingmachine.domain.Customer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final VendingMachine vendingMachine = new VendingMachine();

	public void run() {
		makeVendingMachineHoldingAmount();
		vendingMachine.showHoldingCoins();
		List<String> productList = getProductListFromInput();
		vendingMachine.addProducts(productList);
		int inputMoney = getInputAmountFromInput();
		Customer customer = new Customer(inputMoney);
		customer.showChanges();
		makeVendingMachineTrade(customer);
		vendingMachine.returnChanges(customer.getMoney());
	}

	private void makeVendingMachineTrade(Customer customer) {
		while (vendingMachine.canTrade(customer.getMoney()) && customer.hasMoney()) {
			try {
				String productName = getProductNameToBuyFromInput();
				int productCost = vendingMachine.getProductCost(productName);
				customer.purchaseProduct(productCost);
				vendingMachine.sellProduct(productName);
				customer.showChanges();
			} catch (IllegalArgumentException exception) {
				OutputView.printErrorMessage(exception.getMessage());
			}
		}
	}

	private String getProductNameToBuyFromInput() {
		return InputView.getProductNameToBuyInput();
	}

	private int getInputAmountFromInput() {
		String inputAmountInput = InputView.getInputAmountInput();
		try {
			InputValidator.checkIsValidInputAmountInput(inputAmountInput);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getInputAmountFromInput();
		}
		return Integer.parseInt(inputAmountInput);
	}

	private List<String> getProductListFromInput() {
		String productsInput = InputView.getProductsInput();
		try {
			InputValidator.checkIsValidProductsInput(productsInput);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getProductListFromInput();
		}
		String[] productArray = productsInput.split(";");
		return Arrays.stream(productArray)
			.map(productInfo -> productInfo = productInfo.substring(1, productInfo.length() - 1))
			.collect(Collectors.toList());
	}

	private void makeVendingMachineHoldingAmount() {
		int holdingAmount = getHoldingAmountFromInput();
		vendingMachine.setHoldingAmount(holdingAmount);
	}

	private int getHoldingAmountFromInput() {
		String holdingAmountInput = InputView.getHoldingAmountInput();
		try {
			InputValidator.checkIsValidHoldingAmountInput(holdingAmountInput);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getHoldingAmountFromInput();
		}
		return Integer.parseInt(holdingAmountInput);
	}
}
