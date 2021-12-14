package vendingmachine.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("VendingMachine 클래스")
@ExtendWith(MockitoExtension.class)
class VendingMachineTest {

	@Mock
	Product product;

	private boolean compareHashMap(HashMap<Integer, Integer> expect, HashMap<Integer, Integer> target) {
		return expect.get(Coin.COIN_500.getAmount()).equals(target.get(Coin.COIN_500.getAmount()))
			&& expect.get(Coin.COIN_100.getAmount()).equals(target.get(Coin.COIN_100.getAmount()))
			&& expect.get(Coin.COIN_50.getAmount()).equals(target.get(Coin.COIN_50.getAmount()))
			&& expect.get(Coin.COIN_10.getAmount()).equals(target.get(Coin.COIN_10.getAmount()));
	}

	@DisplayName("자판기 관련 데이터가 정상적으로 할당되는지 확인")
	@ParameterizedTest(name = "{index} {displayName} userInputtedMoney={0}")
	@ValueSource(ints = {200, 1000, 500})
	void checkDataInVendingMachine(final int moneyToInput) {
		final HashMap<Integer, Integer> mockCoinTypesAmount = new HashMap<>();
		mockCoinTypesAmount.put(Coin.COIN_10.getAmount(), 1);
		mockCoinTypesAmount.put(Coin.COIN_50.getAmount(), 1);
		mockCoinTypesAmount.put(Coin.COIN_100.getAmount(), 1);
		mockCoinTypesAmount.put(Coin.COIN_500.getAmount(), 1);

		final ArrayList<Product> mockProducts = new ArrayList<>();
		mockProducts.add(product);
		mockProducts.add(product);

		final VendingMachine vendingMachine = new VendingMachine(
			mockCoinTypesAmount, mockProducts);
		final ArrayList<Product> products = vendingMachine.getProducts();
		assertEquals(0, vendingMachine.getUserInputtedMoney(),
			"초기에 유저가 넣은 돈은 0원이어야 합니다");
		assertTrue(products.containsAll(mockProducts),
			"자판기의 상품리스트가 다르다");
		assertTrue(compareHashMap(mockCoinTypesAmount, vendingMachine.getCoinTypesAmount()),
			"각 동전의 갯수 리스트가 예상과 다르다");
		mockProducts.add(product);

		vendingMachine.setProducts(mockProducts);
		final ArrayList<Product> products1 = vendingMachine.getProducts();
		assertTrue(products1.containsAll(mockProducts),
			"자판기의 상품리스트가 다르다");
		vendingMachine.setUserInputtedMoney(moneyToInput);
		assertEquals(moneyToInput, vendingMachine.getUserInputtedMoney(),
			"자판기가 판별한 유저가 넣은 돈과 실제 유저가 넣은 돈이 다르다");
	}
}
