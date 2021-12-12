package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getUserInputSingleLine(String singleLine) {
		System.out.println(singleLine);
		return Console.readLine();
	}
}
