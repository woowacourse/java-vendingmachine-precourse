package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.Constant.*;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.util.Validator;

public class InputView {

	static Validator validator = new Validator();

	public static String readLineString() {
		return readLine();
	}

	public static List<Item> readItems() {
		String readLine = readLine();
		String products = readLine.replaceAll("\\]", "").replaceAll("\\[", "");
		List<Item> items = new ArrayList<>();
		for (String productPriceAndStock : products.split(DISTINGUISH_BETWEEN_PRODUCTS)) {
			String[] product = productPriceAndStock.split(DISTINGUISH_BETWEEN_PRODUCT_INFORMATION);
			items.add(new Item(product[NAME], Integer.parseInt(product[PRICE]), Integer.parseInt(product[STOCKS])));
		}
		return items;
	}

	public static int readPositiveInt() {
		try {
			String input = readLine();
			validator.validatePrice(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return readPositiveInt();
		}
	}
}
