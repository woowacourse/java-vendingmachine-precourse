package vendingmachine.model;

import vendingmachine.domain.MachineProducts;

public class ProductModel {
	private static MachineProducts products;

	public static void enrollProducts(String information) {
		products = new MachineProducts(information);
	}

	public static boolean hasProductName(String name) {
		return products.hasName(name);
	}

	public static boolean hasMoreThanOneCount(String name) {
		return products.productCountOverOne(name);
	}

	public static boolean canBuyProductWithUserMoney(String name) {
		return products.canBuy(name, MoneyModel.getUserMoney());
	}

	public static void buyProduct(String name) {
		MoneyModel.subtractUserMoney(products.getPrice(name));
		products.buyProduct(name);
	}

	public static boolean canBuyProduct() {
		return !allProductSoldOut() && canBuyCheapestOne();
	}

	private static boolean allProductSoldOut() {
		return products.allProductCountZero();
	}

	private static boolean canBuyCheapestOne() {
		return products.canBuyCheapest(MoneyModel.getUserMoney());
	}
}
