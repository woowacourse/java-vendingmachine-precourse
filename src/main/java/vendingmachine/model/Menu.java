package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.util.ProductException;

public class Menu {
	public Map<String, Product> menuList;

	public Menu(String productInfo) {
		menuList = new HashMap<String, Product>();

		String[] productStrList = productInfo.split(";", -1);

		for (int i = 0; i < productStrList.length; i++) {
			Product product = new Product(productStrList[i].substring(1, productStrList[i].length() - 1));
			ProductException.checkProductReDuplication(menuList, product.getName());
			menuList.put(product.getName(), product);
		}

	}

	public boolean findMenu(String order) {

		if (menuList.containsKey(order)) {
			return true;
		}

		return false;
	}

	public boolean findQuantity(String order) {
		return menuList.get(order).findQuantity();
	}

	public int comparePrice(String order, int insertedMoney) {
		return menuList.get(order).comparePrice(insertedMoney);
	}

	public boolean stopOrdering(int remainMoney) {

		for (Product product : menuList.values()) {

			if (product.canBuyThisProduct(remainMoney)) {
				return false;
			}

		}

		return true;
	}

}
