package vendingmachine.utils.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.message.ErrorMessage;

public class ProductValidator {

	private static final String COMMA = ",";
	private static final int PRICE_INDEX = 1;
	private static final int NAME_INDEX = 0;

	public static boolean checkIsValidToBuyProduct(VendingMachine vendingMachine, String productName) {
		int currentMoney = vendingMachine.getInsertMoney().getCurrentMoney();
		try {
			Product product = vendingMachine.getProducts().getProductByName(productName);
			isValidProductStock(product);
			isValidToBuyProductWithCurrentMoney(product, currentMoney);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static void isValidToBuyProductWithCurrentMoney(Product product, int currentMoney) {
		if (!product.checkPriceWithCurrentMoney(currentMoney)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_BUY_PRODUCT_WITH_CURRENT_MONEY.getText());
		}
	}

	public static void isValidProductStock(Product product) {
		if (!product.checkStock()) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PRODUCT_OUT_OF_STOCK.getText());
		}
	}

	public static boolean checkIsValidProductInfoList(List<String> productInfoList) {
		try {
			for (String productInfo : productInfoList) {
				isValidProductInfoForm(productInfo);
				isValidToDivideByTen(productInfo);
			}
			checkProductDuplicate(productInfoList);
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
	}

	public static void isValidToDivideByTen(String productInfo) {
		String productPrice = Arrays.asList(productInfo.split(COMMA)).get(PRICE_INDEX);
		MoneyValidator.isValidToDivideByTen(productPrice);
	}

	public static void checkProductDuplicate(List<String> productInfoList) {
		Set<String> productNameSet = new HashSet<>();
		for (String productInfo : productInfoList) {
			productNameSet.add(Arrays.asList(productInfo.split(COMMA)).get(NAME_INDEX));
		}
		if (productInfoList.size() != productNameSet.size()) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PRODUCT_NAME_DUPLICATED.getText());
		}
	}

}
