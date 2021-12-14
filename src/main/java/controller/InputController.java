package controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.ProductNameToBuyValidator;
import utils.validator.ChangeValidator;
import utils.validator.InsertedMoneyValidator;
import utils.validator.products.ProductsValidator;

public class InputController {
	private static final boolean INPUT_ERROR = true;

	private InputController() {
	}

	public static int inputChange() {
		while (INPUT_ERROR) {
			try {
				return ChangeValidator.checkValidChange(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static List<String> inputProducts() {
		while (INPUT_ERROR) {
			try {
				return ProductsValidator.checkValidProducts(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static int inputInsertedMoney() {
		while (INPUT_ERROR) {
			try {
				return InsertedMoneyValidator.checkValidInsertedMoney(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static String inputProductNameToBuy() {
		while (INPUT_ERROR) {
			try {
				return ProductNameToBuyValidator.checkValidProductNameToBuy(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
