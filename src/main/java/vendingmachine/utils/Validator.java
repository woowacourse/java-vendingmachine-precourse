package vendingmachine.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.domain.Merchandise;

public class Validator {

	public static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_ERROR_MESSAGE);
		}
	}

	public static void validateEmptyMerchandiseName(String merchandiseName) {
		if (merchandiseName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_EMPTY_NAME_ERROR_MESSAGE);
		}
	}

	public static void validateQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_QUANTITY_ERROR_MESSAGE);
		}
	}

	public static void validateInputMerchandise(String merchandiseInformation) {
		if (!merchandiseInformation.contains("[") || !merchandiseInformation.contains("]")) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_INPUT_ERROR_MESSAGE);
		}
	}

	public static void validateEmptyMerchandiseInformation(String[] merchandiseInformation) {
		if (merchandiseInformation.length < 3) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_INFORMATION_ERROR_MESSAGE);
		}
	}

	public static void validateDuplicateMerchandise(List<Merchandise> merchandiseList) {
		Set<Merchandise> merchandiseSet = new HashSet<>(merchandiseList);
		if (merchandiseSet.size() != merchandiseList.size()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED_MERCHANDISE_ERROR_MESSAGE);
		}
	}

	public static void validateDivideMoneyBy10Coin(int merchandisePrice) {
		if (merchandisePrice % 10 != 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_PRICE_NOT_DIVIDE_10_COIN_ERROR_MESSAGE);
		}
	}
}
