package vendingmachine.Model;

import vendingmachine.Controller.InputController;
import vendingmachine.Utils.Converter;
import vendingmachine.View.OutputView;

public class VendingMachine {
	public CoinWallet machineCoins;
	public final ProductList productList = new ProductList();
	public int userMoney;

	public void init() {
		setMachineCoins();
		OutputView.printEmpty();

		OutputView.printCoin(machineCoins.coins);
		OutputView.printEmpty();

		setMachineProduct();
		OutputView.printEmpty();

		setUserMoney();
		OutputView.printEmpty();
	}

	public void setMachineCoins() {
		machineCoins = new CoinWallet(InputController.setMachineMoney());
	}

	public void setMachineProduct() {
		for (Object[] values : Converter.productConverter(InputController.setProducts())) {
			productList.add(new Product(values));
		}
	}

	public void setUserMoney() {
		userMoney = InputController.setUserMoney();
	}

	public boolean isUserPoor() {
		return userMoney < productList.getMinPrice();
	}

	public boolean allSoldOut() {
		return productList.allSoldOut();
	}
}
