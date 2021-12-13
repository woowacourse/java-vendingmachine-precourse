package utils;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.Validator;

public class InputManager {
	private StringBuilder input;
	private boolean passed = false;
	private Validator validator;

	public String getStringWithInput(Validator validator) {
		while (!passed) {
			this.validator = validator;
			initInput();
		}
		return input.toString();
	}

	private void initInput() {
		try {
			input = new StringBuilder(Console.readLine());
			passed = validator.run(input); // static 으로 만드는게 나을지도?
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
		}
	}
}
