package productcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {
	private static final String PRODUCT_FEATURE_DIVIDER = ",";
	private static final String PRODUCT_DIVIDER = ";";
	private static final String ERROR_MESSAGE_NO_VALID_PRODUCT_NAME
		= "[ERROR] 상품명을 확인해주세요.\n";
	private static final String ERROR_MESSAGE_NO_STOCK
		= "[ERROR] 재고가 없습니다. 다른 제품을 선택해 주세요.\n";
	private static final String ERROR_MESSAGE_NOT_ENOUGH_MONEY
		= "[ERROR] 돈이 부족합니다. 다른 제품을 선택해 주세요.\n";
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int STOCK_INDEX = 2;

	private ArrayList<Product> vendingMachineProducts;
	private ProductRuleChecker productRuleChecker;

	public ProductController() {
		vendingMachineProducts = new ArrayList<>();
		productRuleChecker = new ProductRuleChecker();
	}

	private String offBracket(String target) {
		return target.substring(1, target.length() - 1);
	}

	private void makeProductInstance(String product) {
		product = offBracket(product);
		List<String> productFeature = Arrays.asList(product.split(PRODUCT_FEATURE_DIVIDER));
		vendingMachineProducts.add(
			new Product(productFeature.get(NAME_INDEX), Integer.parseInt(productFeature.get(PRICE_INDEX)),
				Integer.parseInt(productFeature.get(STOCK_INDEX))));
	}

	public void setNewProducts(String products) {
		List<String> productBucket = Arrays.asList(products.split(PRODUCT_DIVIDER));
		for (String product : productBucket) {
			makeProductInstance(product);
		}
	}

	private Product getProduct(String productName) {
		for (Product specificProduct : vendingMachineProducts) {
			if (specificProduct.checkSameProduct(productName)) {
				return specificProduct;
			}
		}
		return null;
	}

	private boolean checkExistStock(Product product) {
		return product.existStock();
	}

	private boolean checkEnoughMoney(Product product, int inputMoney) {
		return product.checkEnoughToBuy(inputMoney);
	}

	private void checkAbleToBuyProductName(Product product, int inputMoney) throws IllegalArgumentException {
		if (product == null) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_VALID_PRODUCT_NAME);
		}
		if (!checkExistStock(product)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_STOCK);
		}
		if (!checkEnoughMoney(product, inputMoney)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_ENOUGH_MONEY);
		}
	}

	public int buyProduct(String productName, int inputMoney) throws IllegalArgumentException {
		Product specificProduct = getProduct(productName);
		checkAbleToBuyProductName(specificProduct, inputMoney);
		return specificProduct.sellOneProduct(inputMoney);
	}

	public boolean checkAllSoldOut() {
		for (Product specificProduct : vendingMachineProducts) {
			if (checkExistStock(specificProduct)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkImpossibleToBuyAnything(int inputMoney) {
		for (Product specificProduct : vendingMachineProducts) {
			if (checkEnoughMoney(specificProduct, inputMoney)) {
				return false;
			}
		}
		return true;
	}

}
