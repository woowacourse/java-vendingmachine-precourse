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

}
