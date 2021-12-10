package vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ErrorMessage;
import vendingmachine.util.ProductException;

public class Menu {
	public Map<String, Integer> nameList;
	public List<Product> menuList;

	public Menu() {
		nameList = new HashMap<String, Integer>();
		menuList = new ArrayList<Product>();
	}

	public void setProductList() {
		menuList = makeProductList();
	}

	public List<Product> makeProductList() {
		List<Product> productList = new ArrayList<Product>();
		try {
			String productListStr = Console.readLine();
			String[] productStrList = productListStr.split(";", -1);

			for (int i = 0; i < productStrList.length; i++) {
				productList.add(new Product(productStrList[i].substring(1, productStrList[i].length() - 1)));
				ProductException.checkProductReDuplication(productList.get(i).getName(), nameList, i);
			}

		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return makeProductList();
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
