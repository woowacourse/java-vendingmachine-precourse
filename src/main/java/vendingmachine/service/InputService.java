package vendingmachine.service;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Constant;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputService {
	private final InputValidator validator = new InputValidator();

	public int readAmount() {
		while (true) {
			try {
				OutputView.print_inputAmount();
				int amount = validator.isPositiveNumber(InputView.getAmount());
				validator.isPossibleMod(amount);
				return amount;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public List<Product> readProducts() {
		while (true) {
			try {
				OutputView.print_inputProduct();
				return makeProductList(InputView.getProducts());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public List<Product> makeProductList(String[] inputArray) {
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = validator.isRightFormat(inputArray[i]);
			validator.isRightPattern(inputArray[i]);

			productList.add(makeProduct(inputArray[i].split(Constant.DELIMITER_CONTENT)));
		}
		return productList;
	}

	public Product makeProduct(String[] input) {
		for (int i = 0; i < Constant.ELEMENT; i++) {
			validator.isNull(input[i]);
		}

		String name = input[Constant.NAME_POSITION];
		int price = validator.validateMoney(input[Constant.PRICE_POSITION]);
		int stock = validator.isPositiveNumber(input[Constant.STOCK_POSITION]);
		return new Product(name, price, stock);
	}

	public int readMoney() {
		while (true) {
			try {
				OutputView.print_inputMoney();
				int money = validator.validateMoney(InputView.getAmount());
				return money;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String readProductName(int money, VendingMachine machine) {
		OutputView.print_money(money);
		OutputView.print_input_ProduntName();
		String name = InputView.getProductName();

		validator.isExist(name, money, machine);

		return name;
	}

}
