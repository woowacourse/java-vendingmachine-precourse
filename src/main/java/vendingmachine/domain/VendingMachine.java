package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
	private final ProductRepository productRepository = new ProductRepository();
	private CoinBox coinBox;

	public void start() {
		makeHoldingMoneyAmount();
		showHoldingCoins();
		makeProducts();
		sellProducts();
	}

	private void sellProducts() {
		OutputView.printInputMoneyRequestMessage();
		int inputMoney = getInputMoneyFromInput();
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

	private void makeHoldingMoneyAmount() {
		OutputView.printHoldingMoneyRequestMessage();
		int holdingMoney = getHoldingMoneyAmountFromInput();
		coinBox = new CoinBox(holdingMoney);
	}

	private int getHoldingMoneyAmountFromInput() {
		return Integer.parseInt(InputView.getHoldingMoneyInput());
	}
}
