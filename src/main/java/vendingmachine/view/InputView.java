package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.exception.NumberException.*;
import static vendingmachine.constant.ViewMessage.*;
import static vendingmachine.exception.ProductException.*;

public class InputView {

	public static int requestPossessionMoney() {
		System.out.println(POSSESSION_MONEY_REQUEST_MESSAGE);
		return Integer.parseInt(requestMoney());
	}

	public static int requestInputMoney() {
		System.out.println(INPUT_MONEY_REQUEST_MESSAGE);
		return Integer.parseInt(requestMoney());
	}

	public static String requestMoney() {
		while (true) {
			String money = readLine();
			try {
				checkNumberException(money);
				return money;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public static String requestProduct() {
		System.out.println();
		System.out.println(PRODUCT_REQUEST_MESSAGE);
		while (true) {
			String products = readLine();
			try {
				checkProductException(products);
				return products;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

}
