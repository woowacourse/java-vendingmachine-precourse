package vendingmachine.view;

import static vendingmachine.constant.Message.*;

import java.util.Map;

import vendingmachine.coin.Coin;
import vendingmachine.machine.Machine;

public class Output {
	public void printCoins(Machine machine) {
		System.out.println();
		System.out.println(MSG_MACHINE_COIN);
		Map<Coin, Integer> coins = machine.getCoins();
		for (Coin coin : Coin.sortedCoins()) {
			System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
		}
	}

	public void printBuy(Machine machine) {
		System.out.println("투입 금액: " + machine.getMoney() + "원");
		System.out.println(MSG_BUY);
	}

	public void printInsertMoney() {
		System.out.println(MSG_INSERT);
	}

	public void printInitMoney() {
		System.out.println(MSG_INIT_MONEY);
	}

	public void printEnd(Machine machine) {
		System.out.println();
		System.out.println("투입 금액: " + machine.getMoney() + "원");
		System.out.println("잔돈");
	}

	public void printInsertProduct() {
		System.out.println();
		System.out.println(MSG_INSERT_PRODUCT);
	}
}
