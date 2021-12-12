package vendingmachine.view;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.Application;
import vendingmachine.domain.Coin;
import vendingmachine.util.PublicConst;
import vendingmachine.util.SystemMessage;

public class ReturnChangesView implements View {
	@Override
	public void flow() {
		int money = Application.controller.getMoney();
		printMoneyAndMessage(money);
		printChanges(money);
	}

	private void printMoneyAndMessage(int money) {
		System.out.println();
		System.out.println(SystemMessage.SHOW_INPUT_MONEY + money + PublicConst.MONETARY_UNIT);
		System.out.println(SystemMessage.RETURN_CHANGES);
	}

	private void printChanges(int money) {
		Map<Coin, Integer> changes = Application.controller.getChangesToBeReturned(money);
		changes.forEach(Coin::printCoinAndCount);
	}
}
