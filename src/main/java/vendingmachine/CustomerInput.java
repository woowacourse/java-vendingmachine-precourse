package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.message.Ask;

public class CustomerInput {
	public String getTotalMachineChanges() {
		System.out.println(Ask.ENTER_MACHINE_CHANGES);
		String input = Console.readLine();
		try {
			validateMachineChangesInput(input);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getTotalMachineChanges();
		}
		return input;
	}

	private void validateMachineChangesInput(String input) {
		Validator.isOnlyNums(input);
	}
}
