package vendingmachine.view;

import static vendingmachine.constant.ViewMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String setVendingMachineWallet() {
		System.out.println(VENDING_MACHINE_WALLET);
		return Console.readLine();
	}

	public static String setProductList() {
		System.out.println(SET_PRODUCT_LIST);
		return Console.readLine();
	}

	public static String setUserBalance() {
		System.out.println(SET_USER_BALANCE);
		return Console.readLine();
	}

	public static String buyProduct() {
		System.out.println(BUY_PRODUCT);
		return Console.readLine();
	}
}
