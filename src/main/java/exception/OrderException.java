package exception;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.model.Product;

/*
주문에 대한 검증을 담당
 */
public class OrderException {
	public static void isExistOrder(String order, List<Product> productList) {
		boolean isExist = productList.stream()
			.map(Product::getName)
			.collect(Collectors.toList())
			.contains(order);
		if (!isExist) {
			throw new IllegalArgumentException(ORDER_NOT_EXIST);
		}
	}

	public static void isProductLeft(Product product) {
		if (product.getQuantity() == ZERO) {
			throw new IllegalArgumentException(ORDER_NOT_LEFT);
		}
	}

	public static void isEnoughToOrder(Product product, int money) {
		if (product.getPrice() > money) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
	}
}
