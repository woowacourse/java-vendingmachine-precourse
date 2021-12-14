package vendingmachine.domain;

import java.util.ArrayList;

import static vendingmachine.Error.*;

public class PurchaseExceptionTest extends BasicTest {
	public String moneyOfChanges;
	public String products;
	public String money;
	public String selectedProduct;

	private PurchaseExceptionTest(String products, String money, String selectedProduct, String errorMessage) {
		this.moneyOfChanges = "450";
		this.products = products;
		this.money = money;
		this.selectedProduct = selectedProduct;
		this.errorMessage = errorMessage;
	}

	public static ArrayList<PurchaseExceptionTest> getPurchaseExceptionTest() {
		ArrayList<PurchaseExceptionTest> purchaseExceptionTests = new ArrayList<>(MAX_TESTCASE);

		purchaseExceptionTests.add(new PurchaseExceptionTest(
			"[콜라,1500,20];[사이다,1000,10]", "3000", "스프라이트", NOT_EXIST_PRODUCT_NAME
		));
		purchaseExceptionTests.add(new PurchaseExceptionTest(
			"[콜라,1500,0];[사이다,1000,0]", "3000", "콜라", NOT_EXIST_PRODUCT
		));
		purchaseExceptionTests.add(new PurchaseExceptionTest(
			"[콜라,1500,20];[사이다,1000,10]", "1200", "콜라", LOWER_MONEY
		));

		return purchaseExceptionTests;
	}
}
