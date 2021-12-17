package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Stock;

public class StockView {

	public Stock getInput() {
		System.out.println(Message.INPUT_STOCK);
		try {
			String input = Console.readLine();
			System.out.println();
			return new Stock(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
			return getInput();
		}
	}

}
