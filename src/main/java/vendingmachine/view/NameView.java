package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Name;

public class NameView {

	public Name getInput() {
		System.out.println(Message.INPUT_MESSAGE_NAME);
		try {
			String input = Console.readLine();
			System.out.println();
			return new Name(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
			return getInput();
		}
	}
}
