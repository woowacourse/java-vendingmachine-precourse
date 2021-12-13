package vendingmachine;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class ValidatorVendingMachine {
	private static final String ERROR_INPUT_MONEY_UNIT = "[ERROR] 입력 금액의 단위는 10원 단위 입니다.";
	private static final String ERROR_INPUT_MONEY_FORMAT = "[ERROR] 입력 금액은 숫자를 입력해 주세요.";
	private static final String ERROR_INPUT_MONEY_GAP = "[ERROR] 입력 금액은 최소 10원 이상 입니다.";
	private static final int MIN_MONEY = 10;
	private static final int ZERO = 0;
	private static final String ERROR_MACHINE_PRODUCT_THREE_FORMAT = "[ERROR] 상품명, 가격, 수량 순으로 올바르게 입력해주세요. 가격은 10원 단위입니다.";
	private static final String ERROR_PRODUCT_PRICE = "[ERROR] 상품 가격을 확인해주세요.";
	private static final String ERROR_PRODUCT_AMOUNT = "[ERROR] 상품 수량을 확인해주세요.";
	private static final String REGEX = "^\\[[a-zA-Z가-힣]+,[1-9][0-9]+0,[1-9][0-9]*]$";
	private static final String REST_DELIMITER = ",";
	private static final int PRODUCT_PRICE_INDEX = 1;
	private static final int PRODUCT_AMOUNT_INDEX = 2;
	private static final int SUBSTRING = 1;
	private static final int PRODUCT_MIN_MONEY = 100;

	private final VendingMachine vendingMachine;

	public ValidatorVendingMachine(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public static void validateMachineMoney(String machineMoney) {
		int machineMoneyValue = validateInputMoneyFormat(machineMoney);
		validateInputMoneyUnit(machineMoneyValue);
		validateInputMoneyGap(machineMoneyValue);
	}

	public static void validateInputMoneyUnit(int machineMoney) {
		if (machineMoney % Coin.COIN_10.getAmount() != ZERO) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_UNIT);
		}
	}

	public static int validateInputMoneyFormat(String machineMoney) {
		try {
			return Integer.parseInt(machineMoney);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_FORMAT);
		}
	}

	public static void validateInputMoneyGap(int machineMoney) {
		if (machineMoney < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_GAP);
		}
	}

	public static String[] validateMachineProduct(String machineProduct) {
		isRegexMatches(machineProduct);
		String removedSquareBrackets = machineProduct.substring(SUBSTRING, machineProduct.length() - SUBSTRING);
		String[] tempProduct = removedSquareBrackets.split(REST_DELIMITER);
		validateProductPriceUnit(tempProduct[PRODUCT_PRICE_INDEX]);
		validateProductPriceMin(tempProduct[PRODUCT_PRICE_INDEX]);
		validateAmountUnderZero(tempProduct[PRODUCT_AMOUNT_INDEX]);

		return tempProduct;
	}

	public static void isRegexMatches(String machineProduct) {
		if (!machineProduct.matches(REGEX)) {
			throw new IllegalArgumentException(ERROR_MACHINE_PRODUCT_THREE_FORMAT);
		}
	}

	public static void validateProductPriceMin(String machineProduct) {
		if (Integer.parseInt(machineProduct) < PRODUCT_MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_PRODUCT_PRICE);
		}
	}

	public static void validateProductPriceUnit(String machineProduct) {
		if (Integer.parseInt(machineProduct) % Coin.COIN_10.getAmount() != ZERO) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_UNIT);
		}
	}

	public static void validateAmountUnderZero(String machineProduct) {
		if (Integer.parseInt(machineProduct) <= ZERO) {
			throw new IllegalArgumentException(ERROR_PRODUCT_AMOUNT);
		}
	}

	public static void validateUserMoney(String userMoney) {
		int userMoneyValue = validateUserMoneyFormat(userMoney);
		validateUserMoneyUnit(userMoneyValue);
		validateUserMoneyGap(userMoneyValue);
	}

	public static void validateUserMoneyUnit(int userMoney) {
		if (userMoney % Coin.COIN_10.getAmount() != ZERO) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_UNIT);
		}

	}

	public static int validateUserMoneyFormat(String userMoney) {
		try {
			return Integer.parseInt(userMoney);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_FORMAT);
		}

	}

	public static void validateUserMoneyGap(int userMoney) {
		if (userMoney < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_INPUT_MONEY_GAP);
		}
	}

}
