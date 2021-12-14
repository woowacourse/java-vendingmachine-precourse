package vendingmachine.model.machine;

import static vendingmachine.model.event.EventType.*;

import java.util.Observable;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.event.Event;

public class VendingMachine extends Observable {
	private Coins coins;
	private int remainMoney;

	public void initExchangeCoins(Coins coins) {
		this.coins = coins;
		setChanged();
		notifyObservers(Event.of(INIT_EXCHANGE_COINS, coins));
	}

	public void inputMoney(int inputMoney) {
		this.remainMoney = inputMoney;
		setChanged();
		notifyObservers(Event.of(REMAIN_MONEY_CHANGED, remainMoney));
	}

	public void pay(int price) {
		remainMoney -= price;
		setChanged();
		notifyObservers(Event.of(REMAIN_MONEY_CHANGED, remainMoney));
	}

	public void close() {
		setChanged();
		notifyObservers(Event.of(CLOSE_VENDING_MACHINE, getRemainCoins()));
	}

	public boolean hasEnoughMoney(int price) {
		return price <= remainMoney;
	}

	private Coins getRemainCoins() {
		if (coins.isLessOrEquals(remainMoney)) {
			return coins;
		}

		return coins.getCloseAmountCoins(remainMoney);
	}
}
