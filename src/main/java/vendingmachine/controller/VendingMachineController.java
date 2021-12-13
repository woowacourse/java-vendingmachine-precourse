package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinCounter;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductService;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.User;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private CoinCounter coinCounter;
	private Products products;
	private final ProductService productService;
	private User user;

	public VendingMachineController() {
		productService = new ProductService();
	}

	public void setVendingMachineCoinCounter() {
		try {
			int amount = InputView.getVendingMachineAmount();
			this.coinCounter = new CoinCounter(Coin.getCoinCounter(amount));
			OutputView.printCoinCounter(this.coinCounter);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			setVendingMachineCoinCounter();
		}
	}

	public void setProducts() {
		try {
			products = new Products();
			List<Product> processedProducts = productService.makeProducts(InputView.getProducts());
			processedProducts.forEach(products::add);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			setProducts();
		}
	}

	public void getUserAmount() {
		try {
			user = new User(InputView.getUserAmount());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			getUserAmount();
		}
	}

	public void useVendingMachine() {
		while (user.canBuyProduct(products)) {
			buyProducts();
		}
	}

	private void buyProducts() {
		try {
			OutputView.printUserAmount(user);
			user.buyProduct(products, InputView.getProductName());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			buyProducts();
		}
	}

	public void returnChange() {
		OutputView.printUserAmount(user);
		CoinCounter changeCoinCounter = coinCounter.getChangeCoinCounter(user);
		OutputView.printChangeCoins(changeCoinCounter);
	}
}
