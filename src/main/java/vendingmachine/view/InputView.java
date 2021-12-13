package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getUserInput(String firstLine) {
		System.out.println(firstLine);
		return Console.readLine();
	}
}
