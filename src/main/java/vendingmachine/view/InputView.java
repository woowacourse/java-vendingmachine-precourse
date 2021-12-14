package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String getAmount() {
		return Console.readLine();
	}
	
	public static String[] getProducts() {
		return Console.readLine().split(";");
	}
	
	public static String getProductName() {
		return Console.readLine();
	}
}
