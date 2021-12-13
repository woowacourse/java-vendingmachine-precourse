package vendingmachine;

public class Item {
	private final static String SPLIT_REGEX = ",";

	private final String name;
	private final int price;
	private final int number;

	public Item(String itemString) {
		System.out.println(itemString);
		itemString = itemString.replace("[", "").replace("]", "");
		String[] itemInfos = itemString.split(SPLIT_REGEX);
		name = itemInfos[0];
		price = Integer.parseInt(itemInfos[1]);
		number = Integer.parseInt(itemInfos[2]);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getNumber() {
		return number;
	}
}
