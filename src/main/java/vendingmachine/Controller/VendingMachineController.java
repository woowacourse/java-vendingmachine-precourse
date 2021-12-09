package vendingmachine.Controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.Model.Product;
import vendingmachine.View.OutputView;

public class VendingMachineController {
	private int machineMoney;
	private int userMoney;
	private String nameInput;
	private LinkedHashMap<Coin, Integer> machineCoins = new LinkedHashMap<>();
	private ArrayList<Product> products = new ArrayList<>();

	public VendingMachineController() {
		set();
		activate();
	}

	private void set() {
		setMachineMoney();
		OutputView.printCoin(machineCoins);
		setMachineProduct();
		setUserMoney();
	}

	private void activate() {
		OutputView.printUserMoney(userMoney);
		setBuyProduct();
		OutputView.printEmpty();
	}

	private void setMachineMoney() {
		machineMoney = InputController.setMachineMoney();

		for (Coin coin : Coin.values()) {
			int divisor = coin.getAmount();
			machineCoins.put(coin, machineMoney / divisor);
			machineMoney %= divisor;
		}
		OutputView.printEmpty();
	}

	private void setMachineProduct() {
		String productString = InputController.setProduct();

		for (String product : productString.split(";")) {
			String[] productValue = product.substring(1, product.length() - 1).split(",");
			products.add(
				new Product(productValue[0], Integer.parseInt(productValue[1]), Integer.parseInt(productValue[2])));
		}
		OutputView.printEmpty();
	}

	private void setUserMoney() {
		userMoney = InputController.setUserMoney();
		OutputView.printEmpty();
	}

	private void setBuyProduct() {
		String[] names = setNames();
		nameInput = InputController.setBuyProduct(names);
	}

	private String[] setNames() {
		return products.stream()
			.map(product -> product.NAME)
			.toArray(String[]::new);
	}
}
