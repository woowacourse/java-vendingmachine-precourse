package userinterface;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Product;
import vendingmachine.Products;

public class OrderManager {
	Products productList;
	DepositManager depositManager;

	public OrderManager(Products productList, DepositManager depositManager) {
		this.productList = productList;
		this.depositManager = depositManager;
	}

	public void run() {
		while (canOrderWithDeposit()) {
			try {
				depositManager.printDeposit();
				System.out.println("구매할 상품명을 입력해 주세요.");
				pickProduct();
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private boolean canOrderWithDeposit() {
		return productList.getMinPrice() <= depositManager.getDeposit();
	}

	private void pickProduct() {
		String productName = Console.readLine();
		Product product = getProductInstance(productName);

		if (!productList.isEmpty(product)) {
			productList.deduct(product);
			depositManager.deduct(product.getPrice());
		}
	}

	private Product getProductInstance(String productName) {
		for (Product product : productList.keySet()) {
			if (product.toString().equals(productName)) {
				return product;
			}
		}
		throw new IllegalArgumentException("[ERROR] 동일한 이름의 상품이 없습니다.");
	}
}
