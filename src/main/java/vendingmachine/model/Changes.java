package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ErrorMessage;
import vendingmachine.constants.InputMessage;
import vendingmachine.util.NumberException;

public class Changes {
	private List<Integer> coinList;
	private int changes;

	public Changes() {
		coinList = new ArrayList<Integer>();
		changes = 0;
	}

	public void setCoinList() {
		changes = setChanges();
	}

	public int setChanges() {
		int money;
		try {
			System.out.println(InputMessage.PREPARING_COIN_MESSAGE);
			String moneyStr = Console.readLine();
			money = NumberException.checkMoneyException(moneyStr);
		} catch (Exception e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return setChanges();
		}
		return money;
	}

}
