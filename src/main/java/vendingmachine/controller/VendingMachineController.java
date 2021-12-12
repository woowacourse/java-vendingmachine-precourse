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
	private static final String SPLITTER_OF_PRODUCT = ";";

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
		while (true) {
			try {
				String inputAmountInput = InputView.getInputAmountInput();
				InputValidator.checkIsValidInputAmountInput(inputAmountInput);
				return Integer.parseInt(inputAmountInput);
			} catch (IllegalArgumentException exception) {
				OutputView.printErrorMessage(exception.getMessage());
			}
		}
	}

	private List<String> getProductListFromInput() {
		while (true) {
			try {
				String productsInput = InputView.getProductsInput();
				InputValidator.checkIsValidProductsInput(productsInput);
				String[] productArray = productsInput.split(SPLITTER_OF_PRODUCT);
				return Arrays.stream(productArray)
					.map(productInfo -> productInfo = productInfo.substring(1, productInfo.length() - 1))
					.collect(Collectors.toList());
			} catch (IllegalArgumentException exception) {
				OutputView.printErrorMessage(exception.getMessage());
			}
		}
	}

	private void makeVendingMachineHoldingAmount() {
		int holdingAmount = getHoldingAmountFromInput();
		vendingMachine.setHoldingAmount(holdingAmount);
	}

	private int getHoldingAmountFromInput() {
		while (true) {
			try {
				String holdingAmountInput = InputView.getHoldingAmountInput();
				InputValidator.checkIsValidHoldingAmountInput(holdingAmountInput);
				return Integer.parseInt(holdingAmountInput);
			} catch (IllegalArgumentException exception) {
				OutputView.printErrorMessage(exception.getMessage());
			}
		}
	}
}
