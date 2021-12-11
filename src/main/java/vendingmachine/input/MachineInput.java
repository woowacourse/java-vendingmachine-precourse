package vendingmachine.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Validator;
import vendingmachine.message.Ask;

public class MachineInput {
	private static final String PRODUCT_INFO_DELIM = ";";

	public int getTotalMachineChanges() {
		System.out.println(Ask.ENTER_MACHINE_CHANGES);
		String input = Console.readLine();
		try {
			validateMachineChangesInput(input);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getTotalMachineChanges();
		}
		return Integer.parseInt(input);
	}

	private void validateMachineChangesInput(String input) {
		Validator.isOnlyNums(input);
	}

	public void getProductsInfo() {
		System.out.println(Ask.ENTER_MACHINE_PRODUCTS);
		String input = Console.readLine();
		validateProductsInfoInput(input);
	}

	private void validateProductsInfoInput(String input) {
		String[] rawProductInfos = input.split(PRODUCT_INFO_DELIM);
		for(String rawInfo : rawProductInfos) {

		}
	}
}
