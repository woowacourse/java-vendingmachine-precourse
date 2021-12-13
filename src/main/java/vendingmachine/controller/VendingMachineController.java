package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.utils.InputValidator;
import vendingmachine.domain.Customer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private static final String SPLITTER_OF_PRODUCT = ";";

	private final VendingMachine vendingMachine = new VendingMachine();

	public void run() {
		requestVendingMachineHoldingAmount();
		showHoldingCoinInfo();
		requestVendingMachineProduct();

		int inputMoney = getInputAmountFromInput();
		Customer customer = new Customer(inputMoney);
		OutputView.printCustomerChanges(customer.getMoney());
		makeVendingMachineTrade(customer);

		requestCustomerChangesReturn(customer);
	}

	private void requestCustomerChangesReturn(Customer customer) {
		OutputView.printChangesMessage();
		List<String> changeInfoList = vendingMachine.getChangeInfoListForCustomer(customer.getMoney());
		changeInfoList.forEach(OutputView::printCoinInfo);
	}

	private void requestVendingMachineProduct() {
		List<String> productList = getProductListFromInput();
		vendingMachine.addProducts(productList);
	}

	private void showHoldingCoinInfo() {
		OutputView.printHoldingCoinMessage();
		List<String> coinInfoLIst = vendingMachine.getHoldingCoinInfoList();
		coinInfoLIst.forEach(OutputView::printCoinInfo);
	}

	private void makeVendingMachineTrade(Customer customer) {
		while (vendingMachine.canTrade(customer.getMoney()) && customer.hasMoney()) {
			try {
				String productName = getProductNameToBuyFromInput();
				int productCost = vendingMachine.getProductCost(productName);
				customer.purchaseProduct(productCost);
				vendingMachine.sellProduct(productName);
				OutputView.printCustomerChanges(customer.getMoney());
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

	private void requestVendingMachineHoldingAmount() {
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
