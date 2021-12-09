package vendingmachine.model;

public class VendingMachine {

	private int deposit;
	private ProductList productList;
	private CoinList coinList;

	public VendingMachine(int deposit, ProductList productList, CoinList coinList) {
		this.deposit = deposit;
		this.productList = productList;
		this.coinList = coinList;
	}

	public ProductList getProductList() {
		return productList;
	}

	public int getDeposit() {
		return deposit;
	}

	public void subtractDeposit(int price) {
		this.deposit -= price;
	}

	public boolean isContinueToSell() {
		int minimumPrice = getMinimumPrice();
		if (minimumPrice > deposit) {
			return false;
		}

		if (isOutOfStock()) {
			return false;
		}

		return true;
	}

	private int getMinimumPrice() {
		int minimumPrice = Integer.MAX_VALUE;
		for (Product product : productList.getHashMap().values()) {
			if (product.getQuantity() == 0) {
				continue;
			}

			minimumPrice = Math.min(minimumPrice, product.getPrice());
		}

		return minimumPrice;
	}

	private boolean isOutOfStock() {
		for (Product product : productList.getHashMap().values()) {
			if (product.getQuantity() > 0) {
				return false;
			}
		}

		return true;
	}

}
