package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.utils.ValidateUtils;

public class InputView {

	public static int inputVendingMachineMoney() {
		String coin = Console.readLine();
		ValidateUtils.validateInputCoin(coin);
		return Integer.parseInt(coin);
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
