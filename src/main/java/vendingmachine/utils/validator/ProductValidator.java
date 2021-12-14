package vendingmachine.utils.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.message.ErrorMessage;

public class ProductValidator {

	private static final int OUT_OF_STOCK = 0;
	private static final String COMMA = ",";
	private static final int PRICE_INDEX = 1;

	public static boolean checkIsValidToBuyProduct(VendingMachine vendingMachine, String productName) {
		int currentMoney = vendingMachine.getInsertMoney().getCurrentMoney();
		try {
			Product product = vendingMachine.getProducts().getProductByName(productName);
			List<Product> productList = vendingMachine.getProducts().getProductList();
			isValidToExistInProductList(productList, product);
			isValidProductStock(product);
			isValidToBuyProductWithCurrentMoney(product, currentMoney);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static void isValidToBuyProductWithCurrentMoney(Product product, int currentMoney) {
		if (currentMoney < product.getPrice()) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_BUY_PRODUCT_WITH_CURRENT_MONEY.getText());
		}
	}

	public static void isValidProductStock(Product product) {
		if (product.getQuantity()==OUT_OF_STOCK) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PRODUCT_OUT_OF_STOCK.getText());
		}
	}

	public static void isValidToExistInProductList(List<Product> productList, Product product) {
		if (!productList.contains(product)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PRODUCT_DOES_NOT_EXIST.getText());
		}
	}


	public static boolean checkIsValidProductInfoList(List<String> productInfoList) {
		try {
			for (String productInfo : productInfoList) {
				isValidProductInfoForm(productInfo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static void isValidProductInfoForm(String productInfo) {
		String regex = "^\\[[a-zA-Z0-9가-힣]+,[0-9]{3,},[0-9]+]$";
		if (!Pattern.matches(regex, productInfo)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PRODUCT_INFO_IS_NOT_VALID.getText());
		}
		String productPrice = Arrays.asList(productInfo.split(COMMA)).get(PRICE_INDEX);
		MoneyValidator.isValidToDivideByTen(productPrice);
	}
}
