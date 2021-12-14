package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.Constant.*;
import static vendingmachine.constant.ViewMessage.*;

public class InputView {

	public static String requestPossessionMoney() {
		System.out.println(POSSESSION_MONEY_REQUEST_MESSAGE);
		return readLine();
	}

	public static String requestInsertMoney() {
		System.out.println(ENTER + INPUT_MONEY_REQUEST_MESSAGE);
		return readLine();
	}

	public static String requestProduct() {
		System.out.println(ENTER + PRODUCT_REQUEST_MESSAGE);
		return readLine();
	}

	public static String requestProductName() {
		System.out.println(PURCHASE_PRODUCT_NAME_REQUEST_MESSAGE);
		return readLine();
	}

}
