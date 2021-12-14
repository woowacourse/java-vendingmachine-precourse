package vendingmachine.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("VendingMachineInput 클래스")
class VendingMachineInputTest {

	VendingMachineInput vendingMachineInput = new VendingMachineInput(new ArrayList<>());

	@DisplayName("유효한 데이터라면 그 값을 반환한다")
	@ParameterizedTest(name = "{displayName} inputtedMoney={0}")
	@ValueSource(strings = {"100", "50", "1000", "10"})
	void inputValidAmountMoney(final String inputtedMoney) {
		InputStream input = new ByteArrayInputStream(inputtedMoney.getBytes());
		System.setIn(input);
		assertEquals(inputtedMoney, vendingMachineInput.inputAmountOfMoney(),
			"입력값은 그대로 반환되야 합니다");
	}

	@DisplayName("자판기가 가지고 있는 상품의 가격, 수량, 상품명을 입력받고 반환한다")
	@ParameterizedTest(name = "{displayName} productsInformation={0}")
	@ValueSource(strings = {"[콜라,1500,20]", "[콜라,1500,20];[사이다,100,10]"})
	void inputProductsInformation(final String productsInformation) {
		InputStream input = new ByteArrayInputStream(productsInformation.getBytes());
		System.setIn(input);

		final String productsString = vendingMachineInput.inputProductsInformation();
		assertEquals(productsString, productsInformation);
	}

	@DisplayName("상품 구매를 위해 투입한 금액에 정상적으로 반환되는지 확인")
	@ParameterizedTest(name = "{displayName} inputtedMoney={0}")
	@ValueSource(strings = {"1000", "500"})
	void inputMoneyToPurchaseProduct(final String inputtedMoney) {
		InputStream input = new ByteArrayInputStream(inputtedMoney.getBytes());
		System.setIn(input);

		assertEquals(inputtedMoney,
			vendingMachineInput.inputMoney(), "투입된 금액과 반환된 금액이 일치하지 않음");
	}

	@DisplayName("상품 구매를 위해 선택한 상품 이름이 정상적으로 반환되는지 확인")
	@ParameterizedTest(name = "{displayName} selectedProduct={0}")
	@ValueSource(strings = {"콜라", "사이다"})
	void selectedProductToPurchase(final String selectedProduct) {
		InputStream input = new ByteArrayInputStream(selectedProduct.getBytes());
		System.setIn(input);

		assertEquals(selectedProduct, vendingMachineInput.selectProduct(),
			"선택한 제품과 반환된 제품 이름이 다르다");
	}


}
