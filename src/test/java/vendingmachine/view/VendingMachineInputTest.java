package vendingmachine.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.models.Product;

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

	@DisplayName("자판기가 가지고 있는 상품의 가격, 수량, 상품명을 입력받고 반환한다")
	@ParameterizedTest(name = "{displayName} productsInformation={0}")
	@ValueSource(strings = {"[콜라,1500,20]", "[콜라,1500,20];[사이다,100,10]"})
	void inputProductsInformation(final String productsInformation) {
		InputStream input = new ByteArrayInputStream(productsInformation.getBytes());
		System.setIn(input);

		final List<String> productsString = Arrays
			.stream(productsInformation.split(";"))
			.collect(Collectors.toList());
		ArrayList<Product> products = new ArrayList<>();
		productsString.forEach(product -> {
			final String[] tempProduct = product.substring(1, product.length() - 1)
				.split(",");
			final String productionName = tempProduct[0];
			final Integer productionPrice = Integer.parseInt(tempProduct[1]);
			final Integer productionAmount = Integer.parseInt(tempProduct[2]);
			products.add(new Product(productionName, productionPrice, productionAmount));
		});

		final ArrayList<Product> returnedProducts = vendingMachineInput.inputProductsInformation();
		Iterator<Product> productsIterator = products.iterator();
		Iterator<Product> returnedProductsIterator = returnedProducts.iterator();
		while(productsIterator.hasNext() && returnedProductsIterator.hasNext()) {
			final Product product1 = productsIterator.next();
			final Product product2 = returnedProductsIterator.next();
			assertEquals(product2.getName(), product1.getName(),
				"제품 정보가 정상적으로 저장되지 않았다");
			assertEquals(product2.getPrice(), product1.getPrice(),
				"제품 정보가 정상적으로 저장되지 않았다");
			assertEquals(product1.getAmount(), product2.getAmount(),
				"제품 정보가 정상적으로 저장되지 않았다");
		}
	}

	@DisplayName("상품 구매를 위해 투입한 금액에 정상적으로 반환되는지 확인")
	@ParameterizedTest(name = "{displayName} inputtedMoney={0}")
	@ValueSource(strings = {"1000", "500"})
	void inputMoneyToPurchaseProduct(final String inputtedMoney) {
		InputStream input = new ByteArrayInputStream(inputtedMoney.getBytes());
		System.setIn(input);

		assertEquals(Integer.parseInt(inputtedMoney),
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
