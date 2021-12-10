package vendingmachine.Controller.Run;

import vendingmachine.Constants;
import vendingmachine.Controller.InputController;
import vendingmachine.Model.CoinWallet;
import vendingmachine.Model.Product;
import vendingmachine.Model.ProductList;
import vendingmachine.View.OutputView;

public class Init {
	public static CoinWallet machineCoins;
	public static final ProductList products = new ProductList();
	public static int userMoney;

	public static void init() {
		machineCoins = new CoinWallet(InputController.setMachineMoney());

		OutputView.printCoin(machineCoins.coins);

		setMachineProduct();
		OutputView.printEmpty();

		setUserMoney();
		OutputView.printEmpty();
	}

	public static void setMachineProduct() {
		for (String product : InputController.setProducts().split(Constants.DELIMITER_PRODUCTS)) {
			String[] values = product.substring(1, product.length() - 1).split(Constants.DELIMITER_PRODUCT);
			products.add(new Product(
				values[0],
				Integer.parseInt(values[1]),
				Integer.parseInt(values[2])
			));
		}
	}

	public static void setUserMoney() {
		userMoney = InputController.setUserMoney();
	}
}
