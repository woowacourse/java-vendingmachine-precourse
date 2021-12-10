package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Stock;

public class StockView {

	public Stock getInput() {
		System.out.println(Message.INPUT_MESSAGE_PRODUCT);
		Stock stock = new Stock();
		try {
			String input = Console.readLine();
			stock.set(input);
		} catch (Exception e) {
			System.out.println(Message.ERROR + e.getMessage());
			return getInput();
		}
		return stock;
	}

}
