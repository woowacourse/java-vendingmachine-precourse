package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String SET_VENDING_MACHINE_INPUT_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String SET_VENDING_MACHINE_INPUT_GOODS = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String SET_USER_INPUT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String SET_USER_INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";

	public static int setVendingMachineMoney() {
		System.out.println(SET_VENDING_MACHINE_INPUT_MONEY);

		while (true) {
			try {
				String MachineMoney = Console.readLine();
				ValidatorVendingMachine.validateMachineMoney(MachineMoney);
				return Integer.parseInt(MachineMoney);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static String[] setVendingMachineGoods() {
		System.out.println(SET_VENDING_MACHINE_INPUT_GOODS);

		while (true) {
			try {
				String[] vendingMachineGoods = Console.readLine().split(";");
				ValidatorVendingMachine.validateMachineProducts(vendingMachineGoods);
				return vendingMachineGoods;
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	public static int setUserMoney() {
		System.out.println(SET_USER_INPUT_MONEY);

		while (true) {
			try {
				String userMoney = Console.readLine();
				ValidatorVendingMachine.validateUserMoney(userMoney);
				return Integer.parseInt(userMoney);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static String setUserInputPurchaseProduct() {
		System.out.println(SET_USER_INPUT_PURCHASE_PRODUCT);

		while (true) {
			try {
				String userPurchaseProduct = Console.readLine();
				ValidatorVendingMachine.validateUserPurchaseProduct(userPurchaseProduct);
				return userPurchaseProduct;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
