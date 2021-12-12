package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Name;
import vendingmachine.domain.ProductRepository;
import vendingmachine.enums.Coin;

public class VendingMachineTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	private final VendingMachine vendingMachine = new VendingMachine();

	@DisplayName("보유 금액을 설정하여 동전을 무작위로 생성하는 기능 테스트")
	@Test
	void init_holding_money_test() {
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

	@DisplayName("숫자가 아닌 보유 금액을 입력 한 경우 예외 테스트")
	@Test
	void init_holding_money_number_format_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					run("OzRagwort");
					vendingMachine.initHoldingMoney();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("보유 금액을 소수로 입력 한 경우 예외 테스트")
	@Test
	void init_holding_money_double_type_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("1.1");
					vendingMachine.initHoldingMoney();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("Integer 최대값보다 더 큰 보유 금액을 입력 한 경우 예외 테스트")
	@Test
	void init_holding_money_overflow_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("5000000000");
					vendingMachine.initHoldingMoney();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("보유 금액을 음수로 입력 한 경우 예외 테스트")
	@Test
	void init_holding_money_negative_number_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("-1");
					vendingMachine.initHoldingMoney();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("보유 금액을 10으로 나누어 떨어지지 않게 입력 한 경우 예외 테스트")
	@Test
	void init_holding_money_divisible_by_10_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("135");
					vendingMachine.initHoldingMoney();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("보유 동전을 출력하는 기능 테스트")
	@Test
	void show_all_coin_quantity_test() {
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
	void register_products_test() {
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

	@DisplayName("숫자가 아닌 상품 가격을 입력 한 경우 예외 테스트")
	@Test
	void register_products_number_format_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					run("[콜라,OzRagwort,20]");
					vendingMachine.registerProducts();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("상품 가격을 소수로 입력 한 경우 예외 테스트")
	@Test
	void register_products_double_type_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("[콜라,1.1,20]");
					vendingMachine.registerProducts();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("Integer 최대값보다 더 큰 상품 가격을 입력 한 경우 예외 테스트")
	@Test
	void register_products_overflow_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("[콜라,50000000000,20]");
					vendingMachine.registerProducts();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("상품 가격을 100미만으로 입력 한 경우 예외 테스트")
	@Test
	void register_products_lower_then_minimum_price_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("[콜라,50,20]");
					vendingMachine.registerProducts();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("상품 가격을 10으로 나누어 떨어지지 않게 입력 한 경우 예외 테스트")
	@Test
	void register_products_divisible_by_10_exception_test() {
		assertSimpleTest(
			() -> {
				try {
					runException("[콜라,135,20]");
					vendingMachine.registerProducts();
					assertThat(output()).contains(ERROR_MESSAGE);
				} catch (final NoSuchElementException ignore) {
				}
			}
		);
	}

	@DisplayName("구매를 위한 돈 투입 기능 테스트")
	@Test
	void insert_money_test() {
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
