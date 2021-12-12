package utils.validator.vendingmachineproducts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachineProductsValidator {
	private static final String BLANK = " ";
	private static final String SEMI_COLON = ";";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품 전체 문자열에 공백이 있다.";
	private static final String FINISH_SEMI_COLON_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품 전체 문자열이 세미콜론으로 끝난다.";

	private VendingMachineProductsValidator() {
	}

	public static List<String> checkValidVendingMachineProducts(String vendingMachineProducts) {
		if (!hasBlankInInput(vendingMachineProducts) && !isFinishAsSemiColon(vendingMachineProducts)) {
			return Arrays.stream(vendingMachineProducts.split(SEMI_COLON))
				.map(VendingMachineProductValidator::checkValidVendingMachineProduct)
				.collect(Collectors.toList());
		}
		throw new IllegalArgumentException();
	}

	private static boolean hasBlankInInput(String vendingMachineProducts) {
		if (vendingMachineProducts.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isFinishAsSemiColon(String vendingMachineProducts) {
		if (vendingMachineProducts.endsWith(SEMI_COLON)) {
			throw new IllegalArgumentException(FINISH_SEMI_COLON_ERROR_MESSAGE);
		}
		return false;
	}
}
