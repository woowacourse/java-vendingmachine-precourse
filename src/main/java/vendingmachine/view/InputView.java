package vendingmachine.view;

import static vendingmachine.utils.Constant.*;
import static vendingmachine.utils.Validate.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String DELIMITER_OF_PRODUCT_LIST = ";";
	public static int INDEX_OF_PRODUCT_SUBSTRING = 1;


	public static int inputHoldingAmountMoney() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		String input = Console.readLine();
		try {
			validateInputHoldingAmountMoney(input);
			printEmptyLine();
			return Integer.parseInt(input);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return inputHoldingAmountMoney();
		}
	}

	public static List<String> inputProductList() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		String input = Console.readLine();
		try {
			List<String> productList = Arrays.asList(input.split(DELIMITER_OF_PRODUCT_LIST));
			validateInputProductList(productList);
			return splitProduct(productList);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return inputProductList();
		}
	}

	private static List<String> splitProduct(List<String> productList) {
		return productList.stream()
			.map(i -> i.substring(INDEX_OF_PRODUCT_SUBSTRING, i.length() - INDEX_OF_PRODUCT_SUBSTRING))
			.collect(Collectors.toList());
	}

	public static int inputUserAmount() {
		System.out.println("투입 금액을 입력해 주세요.");
		String input = Console.readLine();
		try{
			validateInputUserAmount(input);
			return Integer.parseInt(input);
		}catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return inputUserAmount();
		}
	}

	public static String inputPurchaseProductName() {
		System.out.println("구매할 상품명을 입력해 주세요.");
		String input = Console.readLine();
		printEmptyLine();
		return input;
	}

	private static void printEmptyLine() {
		System.out.println();
	}
}
