package vendingmachine.coin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.exception.DomainNotFoundException;

class CoinTest {
	@Test
	@DisplayName("금액과 일치하는 동전이 없다면 예외가 발생한다.")
	public void isExistMoneyInCoin() {
		Assertions.assertThrows(DomainNotFoundException.class, () ->
			Coin.valueOf(Money.of(20))
				.orElseThrow(() -> new DomainNotFoundException(Notification.COIN_NOT_FOUND.getMessage()))
		);
	}
}
