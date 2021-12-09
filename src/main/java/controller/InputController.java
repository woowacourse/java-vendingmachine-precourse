package controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

	private InputController() {
	}

	public static int inputVendingMachineChange() {
		return Integer.parseInt(Console.readLine());
	}
}
