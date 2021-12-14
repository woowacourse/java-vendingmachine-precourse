package vendingmachine.domain;

import static vendingmachine.utils.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
	public static String DELIMITER_PRODUCT_STRING = ",";
	private final List<Product> productList = new ArrayList<>();

	public void createProducts(List<String> productListString) {
		for (String productString : productListString) {
			addProduct(splitProductByDelimiter(productString));
		}
	}

	public int getChangeMoney(String productName, int inputAmount) {
		Product product = findProductByName(productName);
		if (!product.isNotOutOfQuantity()) {
			throw new IllegalArgumentException(ERROR_OUT_OF_STOCK);
		}
		return product.getChangePrice(inputAmount);
	}

	private Product findProductByName(String productName) {
		return productList.stream()
			.filter(i -> i.isSameName(productName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_DO_NOT_HAVE_PRODUCT));
	}

	private List<String> splitProductByDelimiter(String product) {
		return Arrays.stream(product.split(DELIMITER_PRODUCT_STRING))
			.collect(Collectors.toList());
	}

	private void addProduct(List<String> product) {
		productList.add(new Product(product));
	}

	public boolean isWhetherPurchasePossible(int remainingInputAmount) {
		for (Product product : productList) {
			if (product.isPurchaseProduct(remainingInputAmount)) {
				return true;
			}
		}
		return false;
	}

	public boolean isCheckStock() {
		for (Product product : productList) {
			if (product.isNotOutOfQuantity()) {
				return true;
			}
		}
		return false;
	}
}
