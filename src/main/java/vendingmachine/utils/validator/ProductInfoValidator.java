package vendingmachine.utils.validator;

import java.util.List;
import java.util.regex.Pattern;

import vendingmachine.utils.ErrorType;

public class ProductInfoValidator {

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

	public static boolean isValidProductInfoForm(String productInfo) {
		String regex = "^\\[[a-zA-Z0-9가-힣]+,[0-9]{2,},[0-9]+]$";
		if (!Pattern.matches(regex, productInfo)) {
			throw new IllegalArgumentException(ErrorType.ERROR_PRODUCT_INFO_IS_NOT_VALID.getText());
		}
		return true;
	}
}
