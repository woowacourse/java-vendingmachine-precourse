package vendingmachine.view;

import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import vendingmachine.models.Coin;

@DisplayName("VendingMachineOutput 클래스")
@ExtendWith(MockitoExtension.class)
class VendingMachineOutputTest {

	@Mock
	VendingMachineOutput vendingMachineOutput;

	@DisplayName("자판기 내부에 있는 동전 리스트를 출력한다")
	@Test
	void outputCoinTypesAmount() {
		HashMap<Integer, Integer> coinTypesAmount = new HashMap<>();
		coinTypesAmount.put(Coin.COIN_500.getAmount(), 1);
		coinTypesAmount.put(Coin.COIN_100.getAmount(), 1);
		coinTypesAmount.put(Coin.COIN_50.getAmount(), 1);
		coinTypesAmount.put(Coin.COIN_10.getAmount(), 1);

		vendingMachineOutput.printCoinTypesAmount(coinTypesAmount);
		verify(vendingMachineOutput, times(1))
			.printCoinTypesAmount(coinTypesAmount);
	}

	@DisplayName("사용자가 제품 구매를 위해 투입한 금액을 출력한다")
	@ParameterizedTest(name = "{displayName} userInputtedMoney={0}")
	@ValueSource(ints={100})
	void outputUserInputtedMoney(final int userInputtedMoney) {
		vendingMachineOutput.printUserInputtedMoney(userInputtedMoney);
		verify(vendingMachineOutput, times(1))
			.printUserInputtedMoney(userInputtedMoney);
	}

	@DisplayName("잔돈내역을 출력한다")
	@Test
	void outputChanges() {
		HashMap<Integer, Integer> changes = new HashMap<>();
		changes.put(Coin.COIN_500.getAmount(), 1);
		changes.put(Coin.COIN_100.getAmount(), 2);
		vendingMachineOutput.printChanges(1, changes);
		verify(vendingMachineOutput, times(1))
			.printChanges(1, changes);
	}
}
