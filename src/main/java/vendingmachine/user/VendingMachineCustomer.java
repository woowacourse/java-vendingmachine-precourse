package vendingmachine.user;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachineCustomer implements Customer {
	@Override
	public void purchase() {
		System.out.println("투입 금액을 입력해주세요.");
		String inputMoney = Console.readLine();
		System.out.println("투입 금액: 3000원\n"
			+ "구매할 상품명을 입력해 주세요.");
		String purchaseOne = Console.readLine();
		System.out.println("투입 금액: 1500원\n"
			+ "구매할 상품명을 입력해 주세요.");
		String purchaseTwo = Console.readLine();
		System.out.println("투입 금액: 500원\n"
			+ "잔돈\n"
			+ "100원 - 4개\n"
			+ "50원 - 1개");
	}
}
