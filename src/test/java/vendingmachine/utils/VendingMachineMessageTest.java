package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import vendingmachine.models.Coin;

@DisplayName("VendingMachineMessage 클래스")
class VendingMachineMessageTest {

	@DisplayName("유저가 입력해야 하는 데이터를 안내하는 메시지가 정상적으로 가져와 지는지 확인")
	@Test
	void validateInputMessage() {
		assertEquals("자판기가 보유하고 있는 금액을 입력해 주세요.",
			VendingMachineMessage.INPUT_AMOUNT_MONEY_IN_MACHINE);
		assertEquals("상품명과 가격, 수량을 입력해 주세요.",
			VendingMachineMessage.INPUT_PRODUCTS_INFORMATION);
		assertEquals("투입 금액을 입력해 주세요.",
			VendingMachineMessage.INPUT_MONEY);
		assertEquals("구매할 상품명을 입력해 주세요.",
			VendingMachineMessage.SELECT_PRODUCT_TO_PURCHASE);
	}

	@Nested
	@DisplayName("유저가 입력한 정보를 토대로 결과값을 출력한다.")
	@ExtendWith(MockitoExtension.class)
	class OutputData {

		MockedStatic<VendingMachineMessage> mockVendingMachineMessage =
			mockStatic(VendingMachineMessage.class);

		@DisplayName("자판기가 보유하고 있는 동전 종류와 수량")
		@Test
		void printCoinTypesAmount() {
			HashMap<Integer, Integer> coinTypesAmount = new HashMap<>();
			coinTypesAmount.put(Coin.COIN_500.getAmount(), 1);
			coinTypesAmount.put(Coin.COIN_100.getAmount(), 2);
			coinTypesAmount.put(Coin.COIN_50.getAmount(), 3);
			coinTypesAmount.put(Coin.COIN_10.getAmount(), 4);

			mockVendingMachineMessage
				.when(() -> VendingMachineMessage.printCoinTypesAmount(coinTypesAmount))
				.thenAnswer(invocation -> null);
			VendingMachineMessage.printCoinTypesAmount(coinTypesAmount);
			mockVendingMachineMessage.verify(() -> {
				VendingMachineMessage.printCoinTypesAmount(coinTypesAmount);
			});
		}

		@DisplayName("제품 구매를 위해 투입된 금액 확인")
		@ParameterizedTest(name = "{displayName} inputtedMoney={0}")
		@ValueSource(ints = {1000})
		void printInputtedMoney(final int inputtedMoney) {
			mockVendingMachineMessage
				.when(() -> VendingMachineMessage.printUserInputtedMoney(inputtedMoney))
				.thenAnswer(invocation -> null);
			VendingMachineMessage.printUserInputtedMoney(inputtedMoney);
			mockVendingMachineMessage.verify(() -> {
				VendingMachineMessage.printUserInputtedMoney(inputtedMoney);
			});
		}

		@DisplayName("잔돈 리스트 출력")
		@Test
		void printChange() {
			HashMap<Integer, Integer> changes = new HashMap<>();
			changes.put(Coin.COIN_50.getAmount(), 2);
			changes.put(Coin.COIN_100.getAmount(), 1);

			mockVendingMachineMessage
				.when(() -> VendingMachineMessage.printChange(changes))
				.thenAnswer(invocation -> null);
			VendingMachineMessage.printChange(changes);
			mockVendingMachineMessage.verify(() -> {
				VendingMachineMessage.printChange(changes);
			});
		}

		@AfterEach
		void closeMockVendingMachineMessage() {
			mockVendingMachineMessage.close();
		}
	}

	@Nested
	@DisplayName("유저가 잘못된 데이터를 입력했을때 에러 메시지를 출력한다")
	class Error {

		@DisplayName("유효하지 않은 숫자 길이")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(ints = {1})
		void invalidNumberLengthError(final int inputtedData) {
			final String errorMessage = VendingMachineMessage
				.invalidLengthError(inputtedData);
			final String expectedMessage = "[ERROR]: " + inputtedData + " 길이가 너무 짧습니다";
			assertEquals(expectedMessage, errorMessage, "반환된 에러 메시지가 예상과 다르다");
		}

		@DisplayName("유효하지 않은 숫자가 들어온 경유")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(ints = {-1})
		void invalidNumberError(final int inputtedData) {
			final String errorMessage = VendingMachineMessage
				.invalidNumberError(inputtedData);
			final String expectedMessage = "[ERROR]: " + inputtedData + " 숫자는 정수여야 합니다";
			assertEquals(expectedMessage, errorMessage, "반환된 에러 메시지가 예상과 다르다");
		}

		@DisplayName("숫자가 아닌 다른 문자가 포함된 경우")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"2e4r"})
		void notNumberError(final String inputtedData) {
			final String errorMessage = VendingMachineMessage
				.notNumberError(inputtedData);
			final String expectedMessage = "[ERROR]: " + inputtedData + " 숫자만 입력되야 합니다";
			assertEquals(expectedMessage, errorMessage, "반환된 에러 메시지가 예상과 다르다");
		}

		@DisplayName("공백이 들어오면 안되는 곳에 공백이 들어온 경우")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"d er3"})
		void involveBlackError(final String inputtedData) {
			final String errorMessage = VendingMachineMessage
				.involveBlankError(inputtedData);
			final String expectedMessage = "[ERROR]: " + inputtedData + " 공백이 포함되면 안됩니다";
			assertEquals(expectedMessage, errorMessage, "반환된 에러 메시지가 예상과 다르다");
		}
	}
}
