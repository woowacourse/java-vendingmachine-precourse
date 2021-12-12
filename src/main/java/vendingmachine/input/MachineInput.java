package vendingmachine.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.CommonValidator;
import vendingmachine.message.Ask;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.message.Error.NOT_ONLY_NUMS;
import static vendingmachine.message.Error.WRONG_PRICE_UNIT;

public class MachineInput {
	public static final String PRODUCT_INFO_DELIM = ";";

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
		if (!CommonValidator.isOnlyNums(input)) {
			throw new IllegalArgumentException(NOT_ONLY_NUMS);
		}
		if (!CommonValidator.rightMinimumUnit(input)) {
			throw new IllegalArgumentException(WRONG_PRICE_UNIT);
		}
	}

	public List<String> getProductsInfo() {
		System.out.println(Ask.ENTER_MACHINE_PRODUCTS);
		String input = Console.readLine();
		try {
//			validateProductsInfoInput(input);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getProductsInfo();
		}
		return Arrays.stream(input.split(PRODUCT_INFO_DELIM)).collect(Collectors.toList());
	}
}
