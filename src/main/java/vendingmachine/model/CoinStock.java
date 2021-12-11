package vendingmachine.model;

public class CoinStock {
	private int amount;
	private int stock;

	public CoinStock(int amount, int stock) {
		this.amount = amount;
		this.stock = stock;
	}

	public int getTotal() {
		return amount * stock;
	}

	public int getAmount() {
		return amount;
	}

	public int getStock() {
		return stock;
	}

	@Override
	public String toString() {
		return amount + "원 - " + stock + "개";
	}
}
