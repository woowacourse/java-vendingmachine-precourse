package vendingmachine.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.utils.Constant;
import vendingmachine.utils.Validation;

public class InputView {

	public static final String INPUT_HOLDING_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해주세요";
	public static final String INPUT_ENTERED_AMOUNT = "투입 금액을 입력해주세요.";
	public static final String INPUT_PRODUCT_TO_BUY = "구매할 상품명을 입력해주세요";

	public static int getHoldingAmount() {
		System.out.println(INPUT_HOLDING_AMOUNT);
		String holdingAmount = Console.readLine();
		System.out.println();

		try {
			Validation.isHoldingAmount(holdingAmount);
			return Integer.parseInt(holdingAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getHoldingAmount();
		}
	}

	public static Products getProducts() {
		System.out.println(INPUT_PRODUCT);
		String products = Console.readLine();
		System.out.println();

		try {
			Validation.isProducts(products);
			return new Products(Arrays.stream(products.split(Constant.PRODUCTS_SPLIT))
				.map(e -> e.substring(1, e.length() - 1))
				.collect(Collectors.toList())
				.stream().map(e -> e.split(Constant.PRODUCT_SPLIT))
				.map(Product::new).collect(Collectors.toList()));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getProducts();
		}
	}

	public static int getEnteredAmount() {
		System.out.println(INPUT_ENTERED_AMOUNT);
		String enteredAmount = Console.readLine();
		System.out.println();

		try {
			Validation.isEnteredAmount(enteredAmount);
			return Integer.parseInt(enteredAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getEnteredAmount();
		}
	}

	public static Product getProductToBuy(Products products, int enteredAmount) {
		System.out.println(INPUT_PRODUCT_TO_BUY);
		String productName = Console.readLine();
		System.out.println();
		try {
			Validation.isProductToBuy(products, productName, enteredAmount);
			return products.findByName(productName).get();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getProductToBuy(products, enteredAmount);
		}
	}
}
