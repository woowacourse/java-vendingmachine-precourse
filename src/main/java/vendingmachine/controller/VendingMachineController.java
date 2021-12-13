package vendingmachine.controller;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.model.Coins;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.util.StringUtils;
import vendingmachine.view.InputView;

public class VendingMachineController {
	private Coins coins;
	private Products products;

	public VendingMachineController() {
		initCoins();
		initProducts();
	}

	private void initCoins() {
		int inputAmountMoney = InputView.readAmountMoney();
		coins = new Coins(inputAmountMoney);
	}

	public void initProducts() {
		String inputProducts = InputView.readProducts();
		List<String> separatedProducts = StringUtils.splitProduct(inputProducts);
		separatedProducts = StringUtils.removeProductBrackets(separatedProducts);
		List<Product> productList = new ArrayList<>();
		separatedProducts.forEach(product -> productList.add(new Product(StringUtils.parseProductDetail(product))));
		products = new Products(productList);
	}
}
