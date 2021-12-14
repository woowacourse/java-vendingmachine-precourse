package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.VendingMachine;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.Validator.*;
import static vendingmachine.Error.*;
import static vendingmachine.service.VendingMachineManagement.*;
import static vendingmachine.view.Print.*;

public class Input {
	private static List<String> insertProductName = new ArrayList<>();

	// 자판기가 보유하는 금액 관련
	public static String inputMoneyOfChanges() {
		return validateMoneyOfChanges(readLine());
	}

	private static String validateMoneyOfChanges(String input) {
		try {
			validateNumber(input, MONEY_OF_CHANGES_ONLY_NUMBER);
			validateOverZero(input, MONEY_OF_CHANGES_OVER_ZERO);
			validateDividedByTen(input, MONEY_OF_CHANGES_DIVIDED_BY_TEN);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			input = inputMoneyOfChanges();
		}
		return input;
	}

	// 상품 정보 관련
	public static String inputProducts(VendingMachine vendingMachine) {
		return validateProducts(readLine(), vendingMachine);
	}

	private static String validateProducts(String input, VendingMachine vendingMachine) {
		try {
			resetNowInsertProductName();
			validateStringOfProducts(input);
			for (String stringOfProduct : splitStringOfProducts(input)) {
				stringOfProduct = removeTextCoverProduct(stringOfProduct);
				validateStringOfProduct(stringOfProduct, vendingMachine);
				addNowInsertProductName(stringOfProduct);
			}
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			input = inputProducts(vendingMachine);
		}
		return input;
	}

	private static void resetNowInsertProductName() {
		insertProductName.clear();
	}

	private static void validateStringOfProducts(String input) {
		validateEmpty(input, PRODUCT_EMPTY);
		validateCoverTextOfProducts(input, PRODUCTS_COVER_TEXT);
		validateSplitTextOfProduct(input, PRODUCT_SPLIT_TEXT);
	}

	private static void addNowInsertProductName(String stringOfProduct) {
		String[] product = splitStringOfProduct(stringOfProduct);
		String name = product[PRODUCT_NAME_INDEX];

		insertProductName.add(name);
	}

	private static void validateStringOfProduct(String input, VendingMachine vendingMachine) {
		String[] stringOfProduct = splitStringOfProduct(input);

		validateNameOfProduct(stringOfProduct[PRODUCT_NAME_INDEX], vendingMachine);
		validatePriceOfProduct(stringOfProduct[PRODUCT_PRICE_INDEX]);
		validateQuantityOfProduct(stringOfProduct[PRODUCT_QUANTITY_INDEX]);
	}

	private static void validateNameOfProduct(String input, VendingMachine vendingMachine) {
		validateEmpty(input, PRODUCT_NAME_EMPTY);
		validateDuplicated(input, vendingMachine, insertProductName, PRODUCT_NAME_DUPLICATE);
	}

	private static void validatePriceOfProduct(String input) {
		validateNumber(input, PRODUCT_PRICE_ONLY_NUMBER);
		validateProductPriceMinimum(input, PRODUCT_PRICE_MINIMUM);
		validateDividedByTen(input, PRODUCT_PRICE_DIVIDED_BY_TEN);
	}

	private static void validateQuantityOfProduct(String input) {
		validateNumber(input, PRODUCT_QUANTITY_ONLY_NUMBER);
		validateOverZero(input, PRODUCT_QUANTITY_OVER_ZERO);
	}

	// 투입 금액 관련
	public static String inputMoney() {
		String input = readLine();
		input = validateMoney(input);

		return input;
	}

	private static String validateMoney(String input) {
		try {
			validateNumber(input, MONEY_NUMBER);
			validateOverZero(input, MONEY_OVER_ZERO);
			validateDividedByTen(input, MONEY_DIVIDED_BY_TEN);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			input = inputMoney();
		}
		return input;
	}

	// 구매할 상품명 관련
	public static String inputSelectedProduct() {
		String input = readLine();
		input = validateSelectedProduct(input);

		return input;
	}

	private static String validateSelectedProduct(String input) {
		try {
			validateEmpty(input, SELECTED_PRODUCT_EMPTY);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			input = inputSelectedProduct();
		}
		return input;
	}
}
