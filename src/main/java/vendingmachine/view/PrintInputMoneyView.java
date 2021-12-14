package vendingmachine.view;

import java.util.Observable;

import vendingmachine.model.event.Event;
import vendingmachine.model.event.EventType;

public class PrintInputMoneyView extends View {
	@Override
	public void update(Observable o, Object arg) {
		Event event = convertToEvent(arg);

		if (event.isTypeOf(EventType.REMAIN_MONEY_CHANGED)) {
			Integer inputMoney = convertToData(event.getData(), Integer.class);
			System.out.println("투입 금액: " + inputMoney + "원");
		}
	}
}
