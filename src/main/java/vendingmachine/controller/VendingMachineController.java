package vendingmachine.controller;

import java.util.List;
import java.util.Map;

import vendingmachine.domain.coin.CoinCounter;
import vendingmachine.domain.coin.CoinService;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductService;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.User;
import vendingmachine.validator.AmountValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final CoinService coinService;
	private CoinCounter coinCounter;
	private Products products;
	private final ProductService productService;
	private User user;

	public VendingMachineController() {
		coinService = new CoinService();
		productService = new ProductService();
	}

	public void setVendingMachineCoinCounter() {
		int amount = getVendingMachineAmount();
		Map<Integer, Integer> coinCounter = coinService.getCoinCounter(amount);
		this.coinCounter = new CoinCounter(coinCounter);
		OutputView.printCoinCounter(this.coinCounter);
	}

	private int getVendingMachineAmount() {
		try {
			String amount = InputView.getVendingMachineAmount();
			AmountValidator.checkVendingMachineAmount(amount);
			return Integer.parseInt(amount);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getVendingMachineAmount();
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

	public void buyProducts() {
		try {
			OutputView.printUserAmount(user);
			user.buyProduct(products, InputView.getProductName());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			buyProducts();
		}
	}
}
