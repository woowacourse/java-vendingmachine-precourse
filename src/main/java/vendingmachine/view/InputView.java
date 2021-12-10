package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.VendingMachineBalanceDto;

public class InputView {
	// TODO: String 하나만 감싸는 DTO 객체가 필요할지 고민 필요
	public static VendingMachineBalanceDto inputVendingMachineBalance() {
		OutputView.printInputVendingMachineBalance();

		String input = Console.readLine();
		return VendingMachineBalanceDto.from(input);
	}

	public static String inputItems() {
		OutputView.printInputItems();
		return Console.readLine();
	}
}
