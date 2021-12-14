package vendingmachine.view;

import java.util.Observable;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.event.Event;
import vendingmachine.model.event.EventType;

public class PrintRemainInputMoneyCoinsView extends View {
	@Override
	public void update(Observable o, Object arg) {
		Event event = convertToEvent(arg);

		if (event.isTypeOf(EventType.CLOSE_VENDING_MACHINE)) {
			Coins coins = convertToData(event.getData(), Coins.class);
			System.out.println("잔돈");
			coins.stream()
				.filter(coin -> coins.getNumberOf(coin) > 0)
				.forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getNumberOf(coin) + "개"));
		}
	}
}
