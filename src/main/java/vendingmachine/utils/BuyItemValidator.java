package vendingmachine.utils;

import vendingmachine.domain.Machine;

public class BuyItemValidator {
	public static final String ERROR_NOT_IN_MACHINE = "[ERROR] 자판기에 해당 상품이 없습니다.";
	public static final String ERROR_OUT_OF_STOCK = "[ERROR] 해당 상품은 현재 재고가 없습니다";
	public static final String ERROR_NOT_ENOUGH_MONEY = "[ERROR] 금액이 모자랍니다.";

	public static void validateBuyItem(Machine machine, String buyItem, int inputMoney) {
		isInMachine(machine, buyItem);
		isInStock(machine, buyItem);
		isPriceEnough(machine, buyItem, inputMoney);
	}

	private static void isInMachine(Machine machine, String buyItem) {
		if (!machine.contains(buyItem)) {
			throw new IllegalArgumentException(ERROR_NOT_IN_MACHINE);
		}
	}

	private static void isInStock(Machine machine, String buyItem) {
		if (machine.getQuantity(buyItem) == 0) {
			throw new IllegalArgumentException(ERROR_OUT_OF_STOCK);
		}
	}

	private static void isPriceEnough(Machine machine, String buyItem, int inputMoney) {
		if (machine.getPrice(buyItem) > inputMoney) {
			throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
		}
	}

}
