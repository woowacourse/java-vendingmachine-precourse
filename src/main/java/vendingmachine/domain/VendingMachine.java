package vendingmachine.domain;

import java.util.Map;

import vendingmachine.view.InputView;

public class VendingMachine {
	private static final String ERROR_USER_INPUT_MONEY_IS_NOT_ENOUGH = "[ERROR] 금액이 부족합니다.";
	private Changes changes;
	private Products products;
	private Money money;

	public Changes getChanges() {
		return changes;
	}

	public Products getProducts() {
		return products;
	}

	public Money getMoney() {
		return money;
	}

	public void createChange() {
		int totalChanges = InputView.setVendingMachineMoney();
		changes = new Changes(totalChanges);
		changes.generateRandomCoins();
	}

	public Map<Coin, Integer> getReturnChanges() {
		return changes.returnChanges(money.getPrice());
	}

	public void createProducts() {
		products = new Products();
		products.addProduct();
	}

	public void insertMoney() {
		int price = InputView.setUserMoney();
		if (products.getMinProductPrice() > price) {
			throw new IllegalArgumentException(ERROR_USER_INPUT_MONEY_IS_NOT_ENOUGH);
		}
		money = new Money(price);
	}

	public boolean userInputMoneyUnderMinProductPrice() {
		if (products.getMinProductPrice() > money.getPrice()) {
			return true;
		}
		return false;
	}

	private Product validateCanPurchaseProduct(String productName, Products products, Money currentMoney) {
		Product findProduct = products.getProductByName(productName);
		currentMoney.inputUserMoneyUnderProductPrice(findProduct.getPrice());
		return findProduct;
	}

	private void reduceProductAndMoney(Product findProduct, Money currentMoney) {
		int restProductRemains = findProduct.reduceRmains();
		currentMoney.reducePrice(findProduct.getPrice());

		if (restProductRemains == 0) {
			getProducts().removeProduct(findProduct);
		}
	}

	public void purchaseProduct() {

		String productName = InputView.setUserInputPurchaseProduct();
		products = getProducts();
		Money currentMoney = getMoney();
		Product findProduct = validateCanPurchaseProduct(productName, products, currentMoney);
		reduceProductAndMoney(findProduct, currentMoney);
	}

}
