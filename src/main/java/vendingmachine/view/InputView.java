package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public String inputMoney() {
		return Console.readLine();
	}

	public String getItemInput() {
		return Console.readLine();
	}

	public String inputItemName() {
		return Console.readLine();
	}
}
