package exception;

import static constant.StringConstant.*;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.model.Product;

public class OrderException {
	// public static void isExistOrder(String order, List<Product> productList) {
	// 	boolean isExist = productList.stream()
	// 		.map(Product::getName)
	// 		.collect(Collectors.toList())
	// 		.contains(order);
	// 	if (!isExist) {
	// 		throw new IllegalArgumentException(ORDER_NOT_EXIST);
	// 	}
	// }
	//
	// public static void isProductLeft(Product product) {
	// 	if (product.getQuantity() == 0) {
	// 		throw new IllegalArgumentException(ORDER_NOT_LEFT);
	// 	}
	// }
	//
	// public static void isEnoughToOrder(Product product, int money) {
	// 	if (product.getPrice() > money) {
	// 		throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
	// 	}
	// }
}
