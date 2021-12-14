package vendingmachine.domain;

import java.util.ArrayList;

public class SuccessfulTest extends BasicTest {
	public String[] input;
	public String[] output;
	public Integer coin;
	public Integer[] coins;

	private SuccessfulTest(String[] input, String[] output, Integer coin, Integer[] coins) {
		this.input = input;
		this.output = output;
		this.coin = coin;
		this.coins = coins;
	}

	public static ArrayList<SuccessfulTest> getSuccessfulTestData() {
		ArrayList<SuccessfulTest> successfulTestData = new ArrayList<>(MAX_TESTCASE);

		String[] input = {"450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다"};
		String[] output = {"자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개",
			"투입 금액: 3000원", "투입 금액: 1500원"};
		Integer coin = 100;
		Integer[] coins = {100, 100, 100, 50};

		successfulTestData.add(new SuccessfulTest(input, output, coin, coins));

		return successfulTestData;
	}
}
