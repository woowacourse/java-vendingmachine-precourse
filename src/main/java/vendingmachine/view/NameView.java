package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Name;

public class NameView {

	public Name getInput() {
		System.out.println(Message.INPUT_MESSAGE_NAME);
		Name name = new Name();
		try {
			String input = Console.readLine();
			System.out.println();
			name.set(input);
		} catch (Exception e) {
			System.out.println(Message.ERROR + e.getMessage());
			return getInput();
		}
		return name;
	}
}
