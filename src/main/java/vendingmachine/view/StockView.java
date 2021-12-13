package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Stock;

public class StockView {

	public Stock getInput() {
		System.out.println(Message.INPUT_MESSAGE_STOCK);
		Stock stock;
		try {
			String input = Console.readLine();
			System.out.println();
			stock = new Stock(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
			return getInput();
		}
		return stock;
	}

}
