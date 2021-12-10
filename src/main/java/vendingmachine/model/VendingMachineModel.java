package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.resource.User;

public class VendingMachineModel {
	private static final VendingMachineModel vendingMachineModel = new VendingMachineModel();
	private CoinModel coinModel;
	private ItemModel itemModel;
	private User user;

	private VendingMachineModel() {
		coinModel = CoinModel.getCoinModel();
		itemModel = ItemModel.getItemModel();
		user = User.getUser();
	}

	public static VendingMachineModel getVendingMachineModel(){
		return vendingMachineModel;
	}

	public void generateCoins(String initialAmount) {
		coinModel.generateCoins(Integer.parseInt(initialAmount));
	}

	public List<Integer> getNumberOfCoins() {
		return coinModel.getNumberOfCoins();
	}

	public void createItems(String items) {
		itemModel.createItems(parseItemStringIntoItemList(items));
	}

	public void putMoney(String money) {
		user.putMoney(Integer.parseInt(money));
	}

	private List<String> parseItemStringIntoItemList(String items) {
		return Arrays.stream(items.split(";"))
			.map(item -> item.substring(1, item.length() - 1))
			.map(itemElement -> itemElement.split(","))
			.flatMap(Arrays::stream)
			.collect(Collectors.toList());
	}
}
