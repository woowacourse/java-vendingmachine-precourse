package vendingmachine.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import vendingmachine.Model.Coin;
import vendingmachine.Model.Product;
import vendingmachine.Model.ProductList;
import vendingmachine.Util;
import vendingmachine.View.OutputView;

public class VendingMachineController {
	private int userMoney;
	private String nameInput;
	private final LinkedHashMap<Coin, Integer> machineCoins = new LinkedHashMap<>();
	private final LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();
	private final ProductList products = new ProductList();

	public VendingMachineController() {
		set();
		activate();
		giveChanges();
	}

	private void set() {
		setMachineCoins();
		OutputView.printCoin(machineCoins);
		setMachineProduct();
	}

	private void activate() {
		setUserMoney();
		do {
			OutputView.printUserMoney(userMoney);
			setWantedProduct();
			Product resultProduct = products.find(nameInput);
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

	private void setMachineCoins() {
		int machineMoney = InputController.setMachineMoney();
		Arrays.stream(Coin.values()).forEach(coin -> machineCoins.put(coin, 0));

		while (machineMoney != 0) {
			Coin coin = Util.randomCoin();
			if (machineMoney >= coin.getAmount()) {
				machineCoins.replace(coin, machineCoins.get(coin) + 1);
				machineMoney -= coin.getAmount();
			}
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
		nameInput = InputController.setWantedProduct(products.getNames());
		OutputView.printEmpty();
	}

	private boolean isActivateEnd() {
		return userMoney < products.getMinPrice() || products.allSoldOut();
	}
}
