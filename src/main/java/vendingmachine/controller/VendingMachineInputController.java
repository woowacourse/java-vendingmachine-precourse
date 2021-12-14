package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.models.Product;
import vendingmachine.utils.InputtedDataValidation;
import vendingmachine.view.VendingMachineInput;

/**
 * <h1>데이터를 입력받고 검증하는 클래스</h1>
 * 입력이 유효하지 않다면 다시 에러를 띄우고 다시 입력받는다.
 * 입력이 유효하다면 입력 받은 데이터를 알맞은 타입으로 파싱해 반환한다
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-14(V1.0)
 * */

public class VendingMachineInputController {

	private final VendingMachineInput vendingMachineInput;

	private final InputtedDataValidation validation;

	public VendingMachineInputController(final VendingMachineInput vendingMachineInput,
			final InputtedDataValidation validation) {
		this.vendingMachineInput = vendingMachineInput;
		this.validation = validation;
	}


	public int inputAmountOfMoney() {
		final String inputtedMoney = vendingMachineInput.inputAmountOfMoney();
		int amountOfMoney = 0;
		try {
			if(validation.validateNumberInput(inputtedMoney)) {
				amountOfMoney = Integer.parseInt(inputtedMoney);
			}
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			amountOfMoney =  inputAmountOfMoney();
		}
		return amountOfMoney;
	}

	public int inputMoney() {
		final String inputtedMoney = vendingMachineInput.inputMoney();
		int amountOfMoney = 0;
		try {
			if(validation.validateNumberInput(inputtedMoney)) {
				amountOfMoney = Integer.parseInt(inputtedMoney);
			}
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			amountOfMoney =  inputMoney();
		}
		return amountOfMoney;
	}

	private ArrayList<Product> parseProductsInformation(final String productsInformation) {
		final ArrayList<Product> products = new ArrayList<>();
		final List<String> productsList = Arrays
			.stream(productsInformation.split(";"))
			.collect(Collectors.toList());
		productsList.forEach(product -> {
			final String[] productString = product.substring(1, product.length() - 1)
				.split(",");
			final String name = productString[0];
			final Integer price = Integer.parseInt(productString[1]);
			final Integer amount = Integer.parseInt(productString[2]);
			products.add(new Product(name, price, amount));
		});
		return products;
	}

	public ArrayList<Product> inputProductsInformation() {
		final String inputtedProducts = vendingMachineInput.inputProductsInformation();
		ArrayList<Product> products = new ArrayList<>();
		try {
			if(validation.validateProductsInformation(inputtedProducts)) {
				products =  parseProductsInformation(inputtedProducts);
			}
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			products = inputProductsInformation();
		}
		return products;
	}

	public String selectProduct() {
		return vendingMachineInput.selectProduct();
	}
}
