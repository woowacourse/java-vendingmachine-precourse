package vendingmachine.view;

import static vendingmachine.model.event.EventType.INIT_EXCHANGE_COINS;

import java.util.Observable;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.event.Event;

public class PrintInitialExchangeCoinView extends View {
	@Override
	public void update(Observable o, Object obj) {
		Event event = convertToEvent(obj);

		if (event.isTypeOf(INIT_EXCHANGE_COINS)) {
			System.out.println("자판기가 보유한 동전");
			Coins coins = convertToData(event.getData(), Coins.class);
			coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getNumberOf(coin) + "개"));
		}
	}
}
