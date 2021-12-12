package vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.util.ProductException;

public class Menu {
	public Map<String, Integer> nameList;
	public List<Product> menuList;

	public Menu() {
		nameList = new HashMap<String, Integer>();
		menuList = new ArrayList<Product>();
	}

	public void setProductList(String productInfo) {
		menuList = makeProductList(productInfo);
	}

	public List<Product> makeProductList(String productInfo) {
		List<Product> productList = new ArrayList<Product>();
		try {
			String[] productStrList = productInfo.split(";", -1);

			for (int i = 0; i < productStrList.length; i++) {
				productList.add(new Product(productStrList[i].substring(1, productStrList[i].length() - 1)));
				ProductException.checkProductReDuplication(productList.get(i).getName(), nameList, i);
			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return productList;
	}

	public boolean findMenu(String order) {

		if (nameList.containsKey(order)) {
			return true;
		}

		return false;
	}

	public boolean findQuantity(String order) {
		return menuList.get(nameList.get(order)).findQuantity();
	}

	public int comparePrice(String order, int insertedMoney) {
		return menuList.get(nameList.get(order)).comparePrice(insertedMoney);
	}

	public boolean stopOrdering(int remainMoney) {

		for (Product product : menuList) {

			if (product.canBuyThisProduct(remainMoney)) {
				return false;
			}

		}

		return true;
	}

}
