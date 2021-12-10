package vendingmachine.model.machine;

import java.util.Observable;
import vendingmachine.model.coin.Coins;
import vendingmachine.model.event.Event;
import vendingmachine.model.item.Item;
import static vendingmachine.model.event.EventType.*;

public class VendingMachine extends Observable {
	private Coins coins;
	private int inputMoney;

	public void initExchangeCoins(Coins coins) {
		this.coins = coins;
		setChanged();
		notifyObservers(Event.of(INIT_EXCHANGE_COINS, coins));
	}

	public void inputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
		setChanged();
		notifyObservers(Event.of(INPUT_MONEY_CHANGED, inputMoney));
	}

	public void sell(Item item) {
		inputMoney -= item.getPrice();
		item.sell();
		setChanged();
		notifyObservers(Event.of(INPUT_MONEY_CHANGED, inputMoney));
	}

	public void close() {
		setChanged();
		notifyObservers(Event.of(CLOSE_VENDING_MACHINE, getRemainInputMoney()));
	}

	public boolean isOverAndEqualMoney(Item item) {
		return item.isOverAndEqualPrice(inputMoney);
	}

	private Coins getRemainInputMoney() {
		if (coins.getTotalAmount() <= inputMoney) {
			return coins;
		}

		return null;
	}
}
