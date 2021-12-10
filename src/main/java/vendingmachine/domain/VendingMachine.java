package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
	private final ProductRepository productRepository = new ProductRepository();
	private CoinBox coinBox;

	public void start() {
		makeHoldingAmount();
		showHoldingCoins();
		makeProducts();
		sellProducts();
	}

	private void sellProducts() {
		OutputView.printInputMoneyRequestMessage();
		int inputMoney = getInputMoneyFromInput();
		Customer customer = new Customer(inputMoney);
		tradeWithCustomer(customer);
		returnCustomerChanges(customer);
	}

	private void returnCustomerChanges(Customer customer) {
		OutputView.printChangesMessage();
		coinBox.returnChanges(customer.getMoney());
	}

	private void tradeWithCustomer(Customer customer) {
		while (true) {
			customer.showChanges();
			if (!canTrade(customer)) {
				return;
			}
			String productName = InputView.getProductNameToBuyInput();
			int productCost = productRepository.getProductCost(productName);
			customer.purchaseProducts(productCost);
			productRepository.sellProduct(productName);
		}
	}

	private boolean canTrade(Customer customer) {
		return !productRepository.isOutOfStock() && !customer.isNoMoney() && !productRepository.isNoProductForCustomer(
			customer.getMoney());
	}

	private int getInputMoneyFromInput() {
		return Integer.parseInt(InputView.getInputMoneyInput());
	}

	private void makeProducts() {
		OutputView.printProductInputRequestMessage();
		List<String> productList = getProductListFromInput();
		productList.forEach((productInfo) -> {
			String[] info = productInfo.split(",");
			productRepository.addProduct(new Product(info[0], Integer.parseInt(info[1])), Integer.parseInt(info[2]));
		});
	}

	private List<String> getProductListFromInput() {
		String[] productArray = InputView.getProductsInput().split(";");
		return Arrays.stream(productArray)
			.map(productInfo -> productInfo = productInfo.substring(1, productInfo.length() - 2))
			.collect(Collectors.toList());
	}

	private void showHoldingCoins() {
		OutputView.printHoldingCoinMessage();
		coinBox.showCoins();
	}

	private void makeHoldingAmount() {
		int holdingAmount = getHoldingAmountFromInput();
		coinBox = new CoinBox(holdingAmount);
	}

	private int getHoldingAmountFromInput() {
		String holdingAmountInput = InputView.getHoldingAmountInput();
		try {
			InputValidator.checkIsValidHoldingAmount(holdingAmountInput);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getHoldingAmountFromInput();
		}
		return Integer.parseInt(holdingAmountInput);
	}
}
