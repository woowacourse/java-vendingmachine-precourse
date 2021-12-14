package vendingmachine.domain;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Coin;

import static org.assertj.core.api.Assertions.*;
import static vendingmachine.Coin.*;

public class VendingMachineTest {
	private VendingMachine vendingMachine;

	@BeforeEach
	void setUp() {
		Changes changes = new Changes();
		for (Coin coin : Coin.values()) {
			changes.setChanges(coin, 1);
		}
		Products products = new Products();
		products.add(new Product("콜라", new Money(1000), 1));
		products.add(new Product("사이다", new Money(800), 1));
		vendingMachine = new VendingMachine(changes, products);
	}

	@DisplayName("입금")
	@Test
	void deposit() {
		vendingMachine.deposit(new Money(500));
		assertThat(vendingMachine.getRemainingMoney().compareTo(new Money(500)))
			.isEqualTo(0);
	}

	@DisplayName("출금")
	@Test
	void withdraw() {
		vendingMachine.deposit(new Money(500));
		vendingMachine.withdraw(new Money(400));
		assertThat(vendingMachine.getRemainingMoney().compareTo(new Money(100)))
			.isEqualTo(0);
	}

	@DisplayName("구매할 수 있는 상품이 있는지 검사")
	@Test
	void isBuy() {
		vendingMachine.deposit(new Money(700));
		assertThat(vendingMachine.isBuy()).isFalse();
		vendingMachine.deposit(new Money(100));
		assertThat(vendingMachine.isBuy()).isTrue();
	}

	@DisplayName("해당 이름을 가진 상품을 구매할 수 있는지 검사")
	@Test
	void isBuyToName() {
		assertThat(vendingMachine.isBuy("사이다")).isFalse();
		vendingMachine.deposit(new Money(800));
		assertThat(vendingMachine.isBuy("사이다")).isTrue();
		vendingMachine.deposit(new Money(200));
		assertThat(vendingMachine.isBuy("콜라")).isTrue();
	}

	@DisplayName("남은 금액 반환")
	@Test
	void returnChanges() {
		vendingMachine.deposit(new Money(160));
		Changes actual = vendingMachine.returnChanges();
		Map<Coin, Integer> actualMap = actual.getChanges();

		assertThat(actualMap.get(COIN_500)).isEqualTo(0);
		assertThat(actualMap.get(COIN_100)).isEqualTo(1);
		assertThat(actualMap.get(COIN_50)).isEqualTo(1);
		assertThat(actualMap.get(COIN_10)).isEqualTo(1);
	}
}
