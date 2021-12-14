package vendingmachine.domain;

public class Item {
	private final int price;
	private int number;

	public Item(String[] itemInfos) {
		price = Integer.parseInt(itemInfos[1]);
		number = Integer.parseInt(itemInfos[2]);
	}

	public int getPrice() {
		return price;
	}

	public int getNumber() {
		return number;
	}

	public void reduceNumber() {
		number--;
	}
}
