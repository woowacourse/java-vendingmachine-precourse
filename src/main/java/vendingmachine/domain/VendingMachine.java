package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.List;

public class VendingMachine {
	private final CoinStore coinStore;
	private final ProductRepository productRepository =  new ProductRepository();
	private int inputAmount = 0;

	public VendingMachine(int money) {
		coinStore = new CoinStore(money);
	}

	public String getHoldingAmountCoins() {
		return coinStore.toString();
	}

	public void insertProductListInProductRepository(List<String> productListString) {
		productRepository.createProducts(productListString);
	}

	public void insertUserInputAmount(int inputAmount) {
		this.inputAmount = inputAmount;
	}

	public int getInputAmount() {
		return inputAmount;
	}

	public void purchaseProduct(String productName) {
		Product product = productRepository.findProductByName(productName);
		if (!product.isNotOutOfQuantity()) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "선택한 제품의 재고가 없습니다.");
		}
		inputAmount = product.getChangePrice(inputAmount);
	}

	public boolean isPossibleRepurchase() {
		return (productRepository.isCheckStock() && productRepository.isWhetherPurchasePossible(inputAmount));
	}

	public String getChangeAmountToString() {
		return coinStore.changeCoinsToString(inputAmount);
	}
}
