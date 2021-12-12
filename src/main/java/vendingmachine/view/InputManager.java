package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ViewConstants;
import vendingmachine.domain.Product;

public class InputManager {
	private final Validator validator;

	public InputManager() {
		this.validator = new Validator();
	}

	public int getStorageMoney() {
		return getMoneyNumber(ViewConstants.ASK_STORAGE_MONEY);
	}

	public int getUserBalance() {
		return getMoneyNumber(ViewConstants.ASK_USER_BALANCE);
	}

	public int getMoneyNumber(String askMessage) {
		while(true) {
			print(askMessage);
			String inputString = Console.readLine();
			try {
				return validator.validateMoney(inputString);
			}catch (IllegalArgumentException e) {
				print(e.getMessage());
			}
		}
	}

	public List<Product> getProductList() {
		while(true) {
			print(ViewConstants.ASK_PRODUCT_LIST);
			String inputString = Console.readLine();
			try {
				return validator.validateProductList(inputString);
			}catch (IllegalArgumentException e) {
				print(e.getMessage());
			}
		}
	}

	public String getProductName() {
		print(ViewConstants.ASK_PRODUCT_NAME_FOR_BUY);
		return Console.readLine();
	}

	public void print(String message) {
		System.out.println(message);
	}

}
