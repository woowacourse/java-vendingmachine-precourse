package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Name;
import vendingmachine.domain.ProductRepository;
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

	@DisplayName("보유 동전을 출력하는 기능 테스트")
	@Test
	void showAllCoinQuantityTest() {
		assertSimpleTest(
			() -> {
				vendingMachine.showAllCoinQuantity();
				assertThat(output()).contains(
					"자판기가 보유한 동전", "500원 - 0개", "100원 - 0개", "50원 - 0개", "10원 - 0개"
				);
			}
		);
	}

	@DisplayName("상품 등록 기능 테스트")
	@Test
	void registerProductsTest() {
		assertSimpleTest(
			() -> {
				run("[콜라,1500,20];[사이다,1000,10]");
				vendingMachine.registerProducts();
				Name coke = new Name("콜라");
				Name cider = new Name("사이다");
				assertTrue(ProductRepository.findByName(coke).isSameName(coke));
				assertTrue(ProductRepository.findByName(cider).isSameName(cider));
			}
		);
	}

	@DisplayName("구매를 위한 돈 투입 기능 테스트")
	@Test
	void insertMoneyTest() {
		assertSimpleTest(
			() -> {
				run("3000");
				assertEquals(MoneyRepository.get().get(), 0);
				vendingMachine.insertMoney();
				assertEquals(MoneyRepository.get().get(), 3000);
			}
		);
	}

	@Override
	protected void runMain() {
	}
}
