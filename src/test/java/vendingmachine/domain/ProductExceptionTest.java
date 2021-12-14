package vendingmachine.domain;

import static vendingmachine.Error.*;

import java.util.ArrayList;

public class ProductExceptionTest extends BasicTest {
	public String moneyOfChanges;
	public String products;

	private ProductExceptionTest(String products, String errorMessage) {
		this.moneyOfChanges = "1500";
		this.products = products;
		this.errorMessage = errorMessage;
	}

	public static ArrayList<ProductExceptionTest> getProductExceptionTest() {
		ArrayList<ProductExceptionTest> productExceptionTests = new ArrayList<ProductExceptionTest>(MAX_TESTCASE);

		productExceptionTests.add(new ProductExceptionTest(" ", PRODUCTS_COVER_TEXT));
		productExceptionTests.add(new ProductExceptionTest("콜라,100,1", PRODUCTS_COVER_TEXT));
		productExceptionTests.add(new ProductExceptionTest("[콜라]", PRODUCT_SPLIT_TEXT));

		productExceptionTests.add(new ProductExceptionTest("[,,]", PRODUCT_NAME_EMPTY));
		productExceptionTests.add(new ProductExceptionTest("[콜라,100,1];[콜라,100,1]", PRODUCT_NAME_DUPLICATE));

		productExceptionTests.add(new ProductExceptionTest("[콜라,가격,]", PRODUCT_PRICE_ONLY_NUMBER));
		productExceptionTests.add(new ProductExceptionTest("[콜라,50,]", PRODUCT_PRICE_MINIMUM));
		productExceptionTests.add(new ProductExceptionTest("[콜라,123,]", PRODUCT_PRICE_DIVIDED_BY_TEN));

		productExceptionTests.add(new ProductExceptionTest("[콜라,500,수량]", PRODUCT_QUANTITY_ONLY_NUMBER));
		productExceptionTests.add(new ProductExceptionTest("[콜라,500,-1]", PRODUCT_QUANTITY_OVER_ZERO));

		return productExceptionTests;
	}
}
