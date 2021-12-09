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
	private LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();
	private ArrayList<Product> products = new ArrayList<>();

	public VendingMachineController() {
		set();
		activate();
		giveChanges();
	}

	private void set() {
		setMachineMoney();
		OutputView.printCoin(machineCoins);
		setMachineProduct();
	}

	private void activate() {
		setUserMoney();
		do {
			OutputView.printUserMoney(userMoney);
			setWantedProduct();
			Product resultProduct = find(products, nameInput);
			if (resultProduct.PRICE > userMoney || resultProduct.stock == 0) {
				break;
			}
			//팔렸다
			userMoney -= resultProduct.PRICE;
			resultProduct.sell();
		} while (!isActivateEnd());
	}

	private void giveChanges() {
		OutputView.printUserMoney(userMoney);
		setChangeCoins();
		OutputView.printChange(changeCoins);
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

	private void setChangeCoins() {
		for (Coin coin : Coin.values()) {
			int divisor = coin.getAmount();
			int coinAmount = machineCoins.get(coin);

			if ((userMoney / divisor) > coinAmount) {
				changeCoins.put(coin, coinAmount);
				userMoney -= coinAmount * divisor;
				continue;
			}
			changeCoins.put(coin, userMoney / divisor);
			userMoney %= divisor;
		}
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

	private void setWantedProduct() {
		String[] names = getNames();
		nameInput = InputController.setWantedProduct(names);
		OutputView.printEmpty();
	}

	private String[] getNames() {
		return products.stream()
			.map(product -> product.NAME)
			.toArray(String[]::new);
	}

	private Product find(ArrayList<Product> products, String name) {
		return products.stream()
			.filter(product -> product.NAME.equals(nameInput))
			.findAny().get();
	}

	private boolean isActivateEnd() {
		return userMoney < getMinPrice(products) || allSoldOut(products);
	}

	private int getMinPrice(ArrayList<Product> products) {
		return products.stream()
			.map(product -> product.PRICE)
			.max(Integer::compare).get();
	}

	private boolean allSoldOut(ArrayList<Product> products) {
		return products.stream()
			.allMatch(product -> product.stock == 0);
	}
}
