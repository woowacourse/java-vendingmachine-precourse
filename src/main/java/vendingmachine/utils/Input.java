package vendingmachine.utils;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Constant.WHITE_SPACE;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private Input() {

	}

	public static String userInput() {
		return Console.readLine().trim().replaceAll(WHITE_SPACE, EMPTY);
	}
}
