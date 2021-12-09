package vendingmachine.Controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.Model.Product;
import vendingmachine.View.OutputView;

public class VendingMachineController {
	private int machineMoney;
	private LinkedHashMap<Coin, Integer> machineCoins = new LinkedHashMap<>();
	private ArrayList<Product> products = new ArrayList<>();

	public VendingMachineController() {
		setMachineMoney();
		OutputView.printCoin(machineCoins);

		setMachineProduct();
	}

	private void setMachineMoney() {
		machineMoney = InputController.setMoney();

		for (Coin coin : Coin.values()) {
			int divisor = coin.getAmount();
			machineCoins.put(coin, machineMoney / divisor);
			machineMoney %= divisor;
		}
	}

	private void setMachineProduct() {
		String productString = InputController.setProduct();
		for (String product : productString.split(";")) {
			String[] productValue = product.substring(1, product.length() - 1).split(",");
			products.add(
				new Product(productValue[0], Integer.parseInt(productValue[1]), Integer.parseInt(productValue[2])));
		}
	}
}
