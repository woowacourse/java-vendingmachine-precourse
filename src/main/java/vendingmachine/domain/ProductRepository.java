package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
	private final List<Product> productList = new ArrayList<>();

	public void createProducts(List<String> productListString) {
		for (String productString: productListString) {
			addProductByString(splitProductStringByDelimiter(productString));
		}
	}

	public Product findProductByName(String productName) {
		return productList.stream()
			.filter(i->i.isSameName(productName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "입력한 이름의 제품이 없습니다."));
	}

	private List<String> splitProductStringByDelimiter(String productToString) {
		return Arrays.stream(productToString.split(DELIMITER_PRODUCT_STRING))
			.collect(Collectors.toList());
	}

	private void addProductByString(List<String> productString) {
		productList.add(new Product(productString));
	}

	public boolean isWhetherPurchasePossible(int remainingInputAmount) {
		for (Product product: productList) {
			if (product.isPurchaseProduct(remainingInputAmount)) {
				return true;
			}
		}
		return false;
	}
}
