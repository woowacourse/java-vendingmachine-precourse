package vendingmachine.view;

import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
		vendingMachineOutput.printCoinTypesAmount();
		verify(vendingMachineOutput, times(1))
			.printCoinTypesAmount();
	}

	@DisplayName("사용자가 제품 구매를 위해 투입한 금액을 출력한다")
	@Test
	void outputUserInputtedMoney() {
		vendingMachineOutput.printUserInputtedMoney();
		verify(vendingMachineOutput, times(1))
			.printUserInputtedMoney();
	}

	@DisplayName("잔돈내역을 출력한다")
	@Test
	void outputChanges() {
		HashMap<Integer, Integer> changes = new HashMap<>();
		changes.put(Coin.COIN_500.getAmount(), 1);
		changes.put(Coin.COIN_100.getAmount(), 2);
		vendingMachineOutput.printChanges(changes);
		verify(vendingMachineOutput, times(1))
			.printChanges(changes);
	}
}
