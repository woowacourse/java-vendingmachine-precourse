package vendingmachine.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("VendingMachineInput 클래스")
class VendingMachineInputTest {

	VendingMachineInput vendingMachineInput = new VendingMachineInput();

	@DisplayName("자판기가 가지고 있는 돈을 입력하면 그 값을 반환한다")
	@ParameterizedTest(name = "{displayName} inputtedMoney={0}")
	@ValueSource(strings = {"100", "50", "1000", "10"})
	void inputValidAmountMoney(final String inputtedMoney) {
		InputStream input = new ByteArrayInputStream(inputtedMoney.getBytes());
		System.setIn(input);
		assertEquals(Integer.parseInt(inputtedMoney),
			vendingMachineInput.inputAmountOfMoney(),
			"입력값은 그대로 반환되야 합니다");
	}

}
