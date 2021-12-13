package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String setVendingMachineWallet() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		return Console.readLine();
	}

	public static String setProductList() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		return Console.readLine();
	}
}
