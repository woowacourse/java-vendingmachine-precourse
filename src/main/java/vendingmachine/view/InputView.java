package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Constant;

public class InputView {

	public static String getAmount() {
		return Console.readLine();
	}
	
	public static String[] getProducts() {
		return Console.readLine().split(Constant.DELIMITER_PRODUNT);
	}
	
	public static String getProductName() {
		return Console.readLine();
	}
}
