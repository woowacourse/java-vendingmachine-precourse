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
		while(true) {
			print(askMessage);
			String inputString = Console.readLine();
			try {
				return converter.convertMoney(inputString);
			}catch (IllegalArgumentException e) {
				print(e.getMessage());
			}
		}
	}

	public List<Product> getProductList() {
		while(true) {
			print(InputConstants.ASK_PRODUCT_LIST);
			String inputString = Console.readLine();
			try {
				return converter.convertToProductList(inputString);
			}catch (IllegalArgumentException e) {
				print(e.getMessage());
			}
		}
	}

	public String getProductName() {
		print(InputConstants.ASK_PRODUCT_NAME_FOR_BUY);
		return Console.readLine();
	}

	public void print(String message) {
		System.out.println(message);
	}

}
