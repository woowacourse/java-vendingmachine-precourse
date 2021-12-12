package vendingmachine;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.controller.VendingMachine;
import vendingmachine.domain.CoinRepository;
import vendingmachine.enums.Coin;

public class VendingMachineTest extends NsTest {
	private final VendingMachine vendingMachine = new VendingMachine();

	@DisplayName("보유 금액을 설정하여 동전을 무작위로 생성하는 기능 테스트")
	@Test
	void initHoldingMoneyTest() {
		assertRandomNumberInListTest(
			() -> {
				run("450");
				vendingMachine.initHoldingMoney();
				assertEquals(CoinRepository.findQuantityByCoin(Coin.COIN_500).get(), 0);
				assertEquals(CoinRepository.findQuantityByCoin(Coin.COIN_100).get(), 4);
				assertEquals(CoinRepository.findQuantityByCoin(Coin.COIN_50).get(), 1);
				assertEquals(CoinRepository.findQuantityByCoin(Coin.COIN_10).get(), 0);
			},
			100, 100, 100, 100, 50
		);
	}

	@Override
	protected void runMain() {
	}
}
