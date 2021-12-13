package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;

public class InputView {

	public static Money inputVendingMachineMoney() {
		String money = Console.readLine();
		return new Money(money);
	}

	public static Products inputProduct() {
		String inputProducts = Console.readLine();
		return new Products(inputProducts);
	}

	public static Money inputMoney() {
		String inputMoney = Console.readLine();
		return new Money(inputMoney);
	}
}
