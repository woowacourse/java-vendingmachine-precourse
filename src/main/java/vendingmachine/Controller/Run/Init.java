package vendingmachine.Controller.Run;

import java.util.LinkedHashMap;

import vendingmachine.Controller.InputController;
import vendingmachine.Model.Coin;
import vendingmachine.Model.Product;
import vendingmachine.Model.ProductList;
import vendingmachine.Util;
import vendingmachine.View.OutputView;

public class Init {
	public static int machineMoney;
	public static final LinkedHashMap<Coin, Integer> machineCoins = new LinkedHashMap<>();
	public static final ProductList products = new ProductList();
	public static int userMoney;

	public static void init() {
		setMachineCoins();
		OutputView.printCoin(Init.machineCoins);
		setMachineProduct();
		setUserMoney();
	}

	public static void setMachineCoins() {
		coinInit();
		while (machineMoney != 0) {
			coinRandomAdd();
		}
		OutputView.printEmpty();
	}

	private static void coinInit() {
		machineMoney = InputController.setMachineMoney();
		for (Coin coin : Coin.values()) {
			machineCoins.put(coin, 0);
		}
	}

	private static void coinRandomAdd() {
		Coin coin = Util.randomCoin();
		if (machineMoney >= coin.getAmount()) {
			machineCoins.replace(coin, machineCoins.get(coin) + 1);
			machineMoney -= coin.getAmount();
		}
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
