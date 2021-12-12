package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.InputMessage.*;

public class InputView {
	public static String getVendingMachineAmount() {
		System.out.println(ASKING_VENDING_MACHINE_AMOUNT_MESSAGE);
		return readLine();
	}

	public static String getProducts() {
		System.out.println(ASKING_PRODUCT_INFORMATION);
		return readLine();
	}
}
