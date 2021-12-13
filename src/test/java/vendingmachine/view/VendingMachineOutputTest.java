package vendingmachine.view;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("VendingMachineOutput 클래스")
@ExtendWith(MockitoExtension.class)
class VendingMachineOutputTest {

	@Mock
	VendingMachineOutput vendingMachineOutput;

	@DisplayName("자판기 내부에 있는 동전 리스트를 출력한다")
	@Test
	void outputCoinTypesAmount() {
		vendingMachineOutput.printCoinTypesAmount();
		verify(vendingMachineOutput, times(1)).printCoinTypesAmount();
	}

}
