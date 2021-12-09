package vendingmachine.view;

import static vendingmachine.utils.Constant.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static int inputHoldingAmountMoney() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		String input = Console.readLine();
		printEmptyLine();
		return Integer.parseInt(input);
	}

	public static List<String> inputProductList() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		String input = Console.readLine();
		return splitProduct(Arrays.asList(input.split(DELIMITER_OF_PRODUCT_LIST)));
	}

	private static List<String> splitProduct(List<String> productList) {
		return productList.stream()
			.map(i -> i.substring(FIRST_INDEX_FOR_SLICE_PRODUCT_STRING, i.length() - 1))
			.collect(Collectors.toList());
	}

	public static int inputUserAmount() {
		System.out.println("투입 금액을 입력해 주세요.");
		String input = Console.readLine();
		return Integer.parseInt(input);
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
