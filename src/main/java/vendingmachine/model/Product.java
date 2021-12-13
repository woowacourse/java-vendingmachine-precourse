package vendingmachine.model;

import java.util.regex.Pattern;

import vendingmachine.util.Utils;

public class Product {
	private String name;
	private int price;
	private int amount;

	public static Product createProduct(String productInformation) {
		Product product = new Product();
		productInformation = productInformation.replace("[", "").replace("]", "");
		String[] productInfo = productInformation.split(",");
		if (productInfo.length != 3) {
			throw new IllegalArgumentException("[ERROR] 잘못된 상품 정보 입력입니다. 다시 입력해 주세요.");
		}

		if (!Pattern.matches("^[0-9]+$", productInfo[1])) {
			throw new IllegalArgumentException("[ERROR] 상품 가격을 숫자로 입력해주세요.");
		}

		if (!Pattern.matches("^[0-9]+$", productInfo[2])) {
			throw new IllegalArgumentException("[ERROR] 상품 수량을 숫자로 입력해주세요.");
		}

		if (Utils.moneyConverter(productInfo[1]) < 100) {
			throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상이어야합니다.");
		}

		if (Integer.parseInt(productInfo[1])%10 != 0) {
			throw new IllegalArgumentException("[ERROR] 상품 가격은 10원 단위여아합니다.");
		}

		product.name = productInfo[0];
		product.price = Utils.moneyConverter(productInfo[1]);
		product.amount = Integer.parseInt(productInfo[2]);
		return product;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getAmount() {
		return this.amount;
	}

	public Product purchaseProduct() {
		this.amount--;
		return this;
	}
}
