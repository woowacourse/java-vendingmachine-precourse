package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.VendingMachineBalanceDto;

public class InputView {
	public static VendingMachineBalanceDto inputVendingMachineBalance() {
		OutputView.printInputVendingMachineBalance();

		String input = Console.readLine();
		return VendingMachineBalanceDto.from(input);
	}
}
