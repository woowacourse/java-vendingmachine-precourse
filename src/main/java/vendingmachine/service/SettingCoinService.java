package vendingmachine.service;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class SettingCoinService {
	private VendingMachine vendingMachine;
	private UserView userView;
	private VendingMachineView vendingMachineView;

	public SettingCoinService(VendingMachine vendingMachine, UserView userView, VendingMachineView vendingMachineView) {
		this.vendingMachine = vendingMachine;
		this.userView = userView;
		this.vendingMachineView = vendingMachineView;
	}

	public void setInitCoins() {
		boolean successInitCoins = false;
		vendingMachineView.askInitCoins();

		while (!successInitCoins) {
			successInitCoins = setInitCoinsIfItIsRight();
		}

	}

	public boolean setInitCoinsIfItIsRight() {
		try {
			vendingMachine.setCoins(userView.insertInitCoins());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

	public void printInitCoins() {
		vendingMachineView.printInitCoinsComment();

		for (Coin coin : Coin.values()) {
			vendingMachineView.printCoin(vendingMachine.countCoin(coin), coin);
		}
	}

}
