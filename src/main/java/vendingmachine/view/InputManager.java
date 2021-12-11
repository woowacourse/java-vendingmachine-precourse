package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.InputConstants;
import vendingmachine.domain.Product;

public class InputManager {
	private final Converter converter;

	public InputManager() {
		this.converter = new Converter();
	}

	public int getStorageMoney() {
		return getMoneyNumber(InputConstants.ASK_STORAGE_MONEY);
	}

	public int getUserBalance() {
		return getMoneyNumber(InputConstants.ASK_USER_BALANCE);
	}

	public int getMoneyNumber(String askMessage) {
		int money = -1;
		while(true) {
			print(askMessage);
			String inputString = Console.readLine();
			money = validateMoneyAndReturn(inputString);
			if(money != -1) {
				break;
			}
		}
		return money;
	}

	private int validateMoneyAndReturn(String inputString) {
		if(checkErrorWithMoneyNumber(inputString)) {
			return -1;
		}
		int money = converter.convertToInt(inputString);
		if(checkErrorWithMoneyFormat(money)) {
			return -1;
		}
		return money;
	}

	private boolean checkErrorWithMoneyNumber(String inputString) {
		try {
			converter.checkNumberString(inputString);
		}catch(IllegalArgumentException e) {
			print(getErrorMessage(InputConstants.ERROR_MONEY_NUMBER));
			return true;
		}
		return false;
	}

	private boolean checkErrorWithMoneyFormat(int number) {
		try {
			converter.checkDivisionByTen(number);
		}catch (IllegalArgumentException e) {
			print(getErrorMessage(InputConstants.ERROR_MONEY_DIVISION));
			return true;
		}
		return false;
	}

	public List<Product> getProductList() {
		List<Product> productList = null;
		while(true) {
			print(InputConstants.ASK_PRODUCT_LIST);
			String inputString = Console.readLine();
			productList = convertToProductList(inputString);
			if(productList != null) {
				break;
			}
		}
		return productList;
	}

	private List<Product> convertToProductList(String inputString) {
		List<Product> productList;
		try {
			productList = converter.convertToProductList(inputString);
		}catch (IllegalArgumentException e) {
			print(getErrorMessage(InputConstants.ERROR_PRODUCT_LIST));
			return null;
		}
		return productList;
	}

	private void print(String message) {
		System.out.println(message);
	}

	private String getErrorMessage(String message) {
		return String.format(InputConstants.ERROR, message);
	}
}
