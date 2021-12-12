package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ViewConstants;
import vendingmachine.domain.Product;

public class InputManager {
	private static final int MONEY_ERROR_CODE = -1;

	private final Validator validator;

	public InputManager() {
		this.validator = new Validator();
	}

	public int getStorageMoney() {
		while(true) {
			print(ViewConstants.ASK_STORAGE_MONEY);
			String inputString = Console.readLine();
			int money = validateStorageMoney(inputString);
			if(money != MONEY_ERROR_CODE) {
				return money;
			}
		}
	}

	private int validateStorageMoney(String inputString) {
		try {
			return validator.validateCommonMoney(inputString);
		}catch (IllegalArgumentException e) {
			print(e.getMessage());
		}
		return MONEY_ERROR_CODE;
	}

	public int getUserBalance() {
		while(true) {
			print(ViewConstants.ASK_USER_BALANCE);
			String inputString = Console.readLine();
			int money = validateUserBalance(inputString);
			if(money != MONEY_ERROR_CODE) {
				return money;
			}
		}
	}

	private int validateUserBalance(String inputString) {
		try {
			return validator.validatePriceAndUserMoney(inputString);
		}catch (IllegalArgumentException e) {
			print(e.getMessage());
		}
		return MONEY_ERROR_CODE;
	}

	public List<Product> getProductList() {
		while(true) {
			print(ViewConstants.ASK_PRODUCT_LIST);
			String inputString = Console.readLine();
			List<Product> products = validateProductList(inputString);
			if(products != null) {
				return products;
			}
		}
	}

	private List<Product> validateProductList(String inputString) {
		try {
			return validator.validateProductList(inputString);
		}catch (IllegalArgumentException e) {
			print(e.getMessage());
		}
		return null;
	}

	public String getProductName() {
		print(ViewConstants.ASK_PRODUCT_NAME_FOR_BUY);
		return Console.readLine();
	}

	public void print(String message) {
		System.out.println(message);
	}

}
