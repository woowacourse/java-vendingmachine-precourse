package vendingmachine.Controller.Run;

import vendingmachine.Controller.InputController;
import vendingmachine.Model.CoinWallet;
import vendingmachine.Model.Product;
import vendingmachine.Model.ProductList;
import vendingmachine.View.OutputView;

public class Init {
	public static CoinWallet coinWallet;
	public static final ProductList products = new ProductList();
	public static int userMoney;

	public static void init() {
		coinWallet = new CoinWallet(InputController.setMachineMoney());
		OutputView.printCoin(coinWallet.coins);
		setMachineProduct();
		setUserMoney();
	}

	public static void setMachineProduct() {
		String productString = InputController.setProduct();

		for (String product : productString.split(";")) {
			String[] productValue = product.substring(1, product.length() - 1).split(",");
			products.add(
				new Product(productValue[0], Integer.parseInt(productValue[1]), Integer.parseInt(productValue[2])));
		}
		OutputView.printEmpty();
	}

	public static void setUserMoney() {
		userMoney = InputController.setUserMoney();
		OutputView.printEmpty();
	}
}
