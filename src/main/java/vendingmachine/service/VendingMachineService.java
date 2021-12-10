package vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.ItemRepository;
import vendingmachine.util.Symbol;

public class VendingMachineService {
	private static final List<Integer> coin_kind = Arrays.asList(Coin.COIN_10.getAmount(),
		Coin.COIN_50.getAmount(),
		Coin.COIN_100.getAmount(),
		Coin.COIN_500.getAmount());
	private static final int ZERO = 0;

	private final CoinRepository coinRepository;
	private final ItemRepository itemRepository;

	public VendingMachineService() {
		this.coinRepository = new CoinRepository(coin_kind);
		this.itemRepository = new ItemRepository();
	}

	public void changeMoneyToCoin(int money) {
		while (money > ZERO) {
			int coin = Randoms.pickNumberInList(coin_kind);
			if (canChange(money, coin)) {
				coinRepository.addCoin(Coin.fromMoney(coin));
				money -= coin;
			}
		}
	}

	private boolean canChange(int money, int coin) {
		if (money - coin >= ZERO) {
			return true;
		}
		return false;
	}

	public String getMachineSmallChange() {
		return coinRepository.getCurrentMachineCoin();
	}

	public void saveItem(String itemInfo) {
		List<String> listOfInfo = Arrays.asList(decodeInput(itemInfo));
		listOfInfo.stream().map(s -> s.split(","))
			.forEach(s -> itemRepository.addItem(s[0], new Item(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]))));
	}

	private String[] decodeInput(String itemInfo) {
		itemInfo = itemInfo.replaceAll(Symbol.OPEN_BRACES, Symbol.NULL);
		itemInfo = itemInfo.replaceAll(Symbol.CLOSE_BRACES, Symbol.NULL);
		return itemInfo.split(Symbol.SEMICOLON);
	}

	public boolean canBuyAnything(int payMoney) {
		if (payMoney < itemRepository.getMinItemPrice() || itemRepository.isAllItemSoldOut()) {
			return false;
		}
		return true;
	}

	public int buyItem(int payMoney, String itemName) {
		if (!itemRepository.isItemSoldOut(itemName)) {
			return payMoney - itemRepository.buyItemAndGetPrice(itemName);
		}
		return payMoney;
	}

	public String calculateSmallChange(int remainMoney) {
		return coinRepository.subtractCoins(remainMoney);
	}

}
