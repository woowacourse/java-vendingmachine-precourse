package vendingmachine.coin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Money;
import vendingmachine.exception.VendingMachineException;

class CoinTest {
	@Test
	@DisplayName("금액과 일치하는 동전이 없다면 예외가 발생한다.")
	public void isExistMoneyInCoin() {
		Assertions.assertThrows(VendingMachineException.class, () ->
			Coin.valueOf(Money.of(20))
			.orElseThrow(() -> new VendingMachineException(""))
		);
	}
}
