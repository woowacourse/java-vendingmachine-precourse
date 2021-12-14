package vendingmachine.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.controller.CoinController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MoneyTest {
	private static final CoinController coinController = new CoinController(
		new InputView(), new OutputView());
	private static Coins coins;

	void init() {
		String input = "250"; // 자판기 보유 금액을 설정한다.
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		coins = coinController.initializeCoins(); // 보유 금액만큼 최소 갯수의 동전을 생성한다.
	}

	@DisplayName("예상 잔돈 반환 갯수 만큼 잔돈을 반환하는지 확인한다.")
	@Test
	public void makeChanges() {
		init();
		Map<Integer, Integer> result = new Money(400).makeChanges(coins); // 투입 금액에 대한 잔돈을 얻어온다.
		Assertions.assertTrue(result.get(100) == 2 && result.get(50) == 1);
		Map<Integer, Integer> result2 = new Money(150).makeChanges(coins);
		Assertions.assertTrue(result2.get(100) == 1 && result2.get(50) == 1);
	}
}
