package vendingmachine.model;

import java.util.Map;

import vendingmachine.validation.VendingMachineValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {

	private final Wallet wallet;
	private final ProductList productList;

	public VendingMachine() {
		wallet = new Wallet();
		productList = new ProductList();
	}

	public boolean isRemainProduct() {
		return productList.isRemainProduct();
	}

	public boolean canBuy(User user) {
		int minPrice = productList.getRemainMinPrice();
		return user.canBuy(minPrice);
	}

	public void buyProduct(User user) {
		String name = InputView.buyProduct();
		try {
			Product product = VendingMachineValidation.buyProduct(productList, name, user);
			product.reduceStock();
			user.buyProduct(product.getPrice());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.illegalArgumentException(illegalArgumentException.getMessage());
			buyProduct(user);
		}
	}

	public void getChange(User user) {
		Change change = new Change(wallet, user.getBalance());
		Map<Coin, Integer> remainCoin = change.calculateChange();
		OutputView.remainCoins(remainCoin);
	}
}
