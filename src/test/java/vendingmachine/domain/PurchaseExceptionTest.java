package vendingmachine.domain;

import java.util.ArrayList;

import static vendingmachine.Error.*;

public class PurchaseExceptionTest extends BasicTest {
	public String moneyOfChanges;
	public String products;
	public String money;
	public String selectedProduct;

	private PurchaseExceptionTest(String selectedProduct, String errorMessage) {
		this.moneyOfChanges = "450";
		this.products = "[콜라,1500,20];[사이다,1000,10]";
		this.money = "3000";
		this.selectedProduct = selectedProduct;
		this.errorMessage = errorMessage;
	}

	public static ArrayList<PurchaseExceptionTest> getPurchaseExceptionTest() {
		ArrayList<PurchaseExceptionTest> purchaseExceptionTests = new ArrayList<>(MAX_TESTCASE);

		purchaseExceptionTests.add(new PurchaseExceptionTest("스프라이트", NOT_EXIST_PRODUCT_NAME));

		return purchaseExceptionTests;
	}
}
