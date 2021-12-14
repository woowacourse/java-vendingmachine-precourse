package vendingmachine.repository;

public enum Coin {
	COIN_500(500, 0),
	COIN_100(100, 0),
	COIN_50(50, 0),
	COIN_10(10, 0);

	private final int amount;
	private int stock;

	Coin(final int amount, int stock) {
		this.amount = amount;
		this.stock = stock;
	}

	// 추가 기능 구현
	public int getAmount() {
		return this.amount;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void addStock() {
		this.stock++;
	}

	public void subtractStock(int number) {
		this.stock -= number;
	}
}