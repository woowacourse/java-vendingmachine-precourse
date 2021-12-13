package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static vendingmachine.view.Print.*;
import static vendingmachine.Validator.*;
import static vendingmachine.service.VendingMachineManagement.*;

import vendingmachine.domain.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
	private VendingMachine vendingMachine;
	private List<String> insertProductName = new ArrayList<>();

	public Administrator(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public String getMoneyOfChanges() {
		String input = readLine();
		input = validateMoneyOfChanges(input);

		return input;
	}

	private String validateMoneyOfChanges(String input) {
		try {
			validateNumber(input);
			validateOverZero(input);
			validateDividedByTen(input);
		} catch (Exception e) {
			printError(e.getMessage());
			input = getMoneyOfChanges();
		}

		return input;
	}

	public String getProducts() {
		String input = readLine();
		input = validateProducts(input);

		return input;
	}

	private String validateProducts(String input) {
		try {
			resetNowInsertProductName();
			validateStringOfProducts(input);
			for (String stringOfProduct : splitStringOfProducts(input)) {
				stringOfProduct = removeTextCoverProduct(stringOfProduct);
				validateStringOfProduct(stringOfProduct);
				addNowInsertProductName(stringOfProduct);
			}
		} catch (Exception e) {
			printError(e.getMessage());
			input = getProducts();
		}
		return input;
	}

	private void resetNowInsertProductName() {
		insertProductName.clear();
	}

	private void validateStringOfProducts(String input) {
		validateEmpty(input);
		validateCoverTextOfProducts(input);
		validateSplitTextOfProduct(input);
	}

	private void addNowInsertProductName(String stringOfProduct) {
		String[] product = splitStringOfProduct(stringOfProduct);
		String name = product[PRODUCT_NAME_INDEX];

		insertProductName.add(name);
	}

	private void validateStringOfProduct(String input) {
		String[] stringOfProduct = splitStringOfProduct(input);

		validateNameOfProduct(stringOfProduct[PRODUCT_NAME_INDEX]);
		validatePriceOfProduct(stringOfProduct[PRODUCT_PRICE_INDEX]);
		validateQuantityOfProduct(stringOfProduct[PRODUCT_QUANTITY_INDEX]);
	}

	private void validateNameOfProduct(String input) {
		validateProductNameEmpty(input);
		validateDuplicatedProductName(input, vendingMachine, insertProductName);
	}

	private void validatePriceOfProduct(String input) {
		validateProductPriceNumber(input);
		validateProductPriceMinimum(input);
		validateProductPriceDividedByTen(input);
	}

	private void validateQuantityOfProduct(String input) {
		validateProductQuantityNumber(input);
		validateProductQuantityOverZero(input);
	}
}
