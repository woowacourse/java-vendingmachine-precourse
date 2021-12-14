package vendingmachine.domain;

import java.util.ArrayList;

import static vendingmachine.Error.*;

public class MoneyExceptionTest extends BasicTest {
	public String moneyOfChanges;
	public String products;
	public String money;

	private MoneyExceptionTest(String money, String errorMessage) {
		this.moneyOfChanges = "450";
		this.products = "[콜라,1500,20];[사이다,1000,10]";
		this.money = money;
		this.errorMessage = errorMessage;
	}

	public static ArrayList<MoneyExceptionTest> getMoneyExceptionTest() {
		ArrayList<MoneyExceptionTest> moneyExceptionTests = new ArrayList<>(MAX_TESTCASE);

		moneyExceptionTests.add(new MoneyExceptionTest("test", MONEY_NUMBER));
		moneyExceptionTests.add(new MoneyExceptionTest("-1", MONEY_OVER_ZERO));
		moneyExceptionTests.add(new MoneyExceptionTest("123", MONEY_DIVIDED_BY_TEN));

		return moneyExceptionTests;
	}
}
