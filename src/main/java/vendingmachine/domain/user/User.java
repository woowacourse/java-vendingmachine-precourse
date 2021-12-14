package vendingmachine.domain.user;

import java.util.List;

import vendingmachine.domain.machine.Machine;
import vendingmachine.domain.machine.coin.Coin;
import vendingmachine.domain.machine.coin.storage.CoinStorage;
import vendingmachine.domain.machine.coin.storage.CoinStorageImpl;

public class User {

	private Machine machine;
	private Balance balance = new Balance();
	private CoinStorage coinStorage = new CoinStorageImpl();

	public User(Machine machine) {
		this.machine = machine;
	}

	public void depositMoney(int money) {
		balance.deposit(money);
	}

	public void withdrawMoney(int money) {
		balance.withdraw(money);
	}

	public void purchase(String productName) {
		machine.purchaseProduct(balance, productName);
	}

	public void refund() {
		machine.refund(this);
	}

	public Balance getBalance() {
		return balance;
	}

	public void saveCoin(Coin coin) {
		coinStorage.save(coin);
	}

	public boolean hasNotLessThan(int money) {
		return balance.isNotLessThan(money);
	}

	public int getCurrentMoney() {
		return balance.getMoney();
	}

	public boolean hasNotEnoughMoney() {
		return machine.isPossibleToUseWith(balance);
	}

	public List<String> getCoinsByString() {
		return coinStorage.getExistedCoinsAsString();
	}

}
