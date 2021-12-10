package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int getSavedMoney() {
		return Integer.parseInt(Console.readLine());
	}

	public String getItemInput() {
		return Console.readLine();
	}

}
