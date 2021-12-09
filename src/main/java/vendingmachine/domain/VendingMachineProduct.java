package vendingmachine.domain;

public class VendingMachineProduct {
	private final String name;
	private final Integer price;
	private final Integer amount;

	public VendingMachineProduct(String name, Integer price, Integer amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
}
