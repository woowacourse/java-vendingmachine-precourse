package vendingmachine;

import java.util.Map;
import java.util.Scanner;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Count;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		final Scanner scanner = new Scanner(System.in);
		VendingMachineController vendingMachineController = new VendingMachineController(scanner);
		String holdingMoney = vendingMachineController.scanHoldingMoney();
		Map<Coin, Count> coins = Coins.moneyToCoins(holdingMoney);
	}
}
