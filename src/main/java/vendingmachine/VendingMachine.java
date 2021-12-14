package vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	public static void start(Items[] items, List<Integer> coinList, int amount) {
		int itemPrice;
		int itemStock;
		int minPrice = checkMinPrice(items);
		int allStock = checkAllStock(items);
		int inputMoney = InputData.inputMoney();

		do {
			int itemIndex = InputData.buyItem(items);
			itemPrice = items[itemIndex].getPrice();
			itemStock = items[itemIndex].sellItem();

			if (itemStock >= 0 && inputMoney > minPrice) {
				allStock--;
				inputMoney = inputMoney - itemPrice;
				Output.printMoney(inputMoney);
			}
		} while (printChange(coinList, amount, inputMoney, minPrice, itemStock, allStock));
	}

	public static boolean printChange(List<Integer> coinList, int amount, int inputMoney, int minPrice, int itemStock,
		int allStock) {
		try {
			InputException.soldOut(itemStock, allStock);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		if (inputMoney == 0 || allStock == 0 || inputMoney < minPrice) {
			changeBack(coinList, amount, inputMoney);
			return false;
		}
		return true;
	}

	public static List<Integer> changeBack(List<Integer> coinList, int amount, int inputMoney) {
		int sum = 0;
		int changedMoney = inputMoney;
		List<Integer> changeList = new ArrayList<Integer>();
		for (int i = 0; i < coinList.size(); i++) {
			if (changedMoney - (int)coinList.get(i) < 0) {
				continue;
			}
			if (sum <= inputMoney) {
				changeList.add(coinList.get(i));
				sum += (int)coinList.get(i);
				changedMoney -= (int)coinList.get(i);
			}
		}
		Collections.sort(changeList, Collections.reverseOrder());
		Output.changeMoney(changeList, coinType(changeList));

		return changeList;
	}

	public static List<Integer> coinType(List<Integer> changeBack) {
		Set<Integer> tmp = new HashSet<Integer>(changeBack);
		List<Integer> coinType = new ArrayList<Integer>(tmp);

		Collections.sort(coinType, Collections.reverseOrder());

		return coinType;
	}

	public static int checkAllStock(Items[] items) {
		int allStock = 0;
		for (int i = 0; i < items.length; i++) {
			allStock += items[i].getStock();
		}

		return allStock;
	}

	public static int checkMinPrice(Items[] items) {
		int minPrice = items[0].getPrice();
		for (int i = 1; i < items.length; i++) {
			if (minPrice > items[i].getPrice()) {
				minPrice = items[i].getPrice();
			}
		}
		return minPrice;
	}

	public Items[] makeItem() {
		String[] setItem = InputData.setItem();
		Items[] items = new Items[setItem.length];

		for (int i = 0; i < setItem.length; i++) {
			String[] item = setItem[i].replace("[", "").replace("]", "").replace(" ", "").split(",");
			items[i] = new Items(item[0], item[1], item[2]);
		}

		return items;
	}

	public List<Integer> randomCoin(int amount) {
		List<Integer> coinList = new ArrayList<Integer>();

		while (amount != 0) {
			Coin coin = Coin.getRandomCoin(randomIndex());
			int coinValue = coin.getAmount();

			if (amount - coinValue >= 0) {
				amount -= coinValue;
				coinList.add(coinValue);
			}
		}
		Collections.sort(coinList, Collections.reverseOrder());
		Output.numberOfCoin(coinList);
		return coinList;
	}

	public int randomIndex() {
		int index = Randoms.pickNumberInRange(0, 3);

		return index;
	}
}
