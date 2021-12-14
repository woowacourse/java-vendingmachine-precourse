package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	final static int BIG_NUMBER= 9999999;
	int totalCoin;

	HashMap<Coin, Integer> coinMap = new HashMap<>();
	HashMap<Coin, Integer> greedyMap = new HashMap<>();
	static ArrayList<Beverage> Beverages = new ArrayList<>();

	public VendingMachine(String cash) {
		this.totalCoin = Integer.parseInt(cash);
		init();
		makeRandomCoin();
	}

	private void init() {
		for (Coin money : Coin.values()) {
			coinMap.put(money, 0);
		}
	}

	public int getTotalCoin() {
		return totalCoin;
	}

	// 랜덤 코인 생성
	private void makeRandomCoin() {
		int remainCoin = 0;
		while (remainCoin != totalCoin) {
			int randomCoin = Randoms.pickNumberInList(Coin.coinList());
			if ((remainCoin + randomCoin) > totalCoin) {
				continue;
			}
			remainCoin += randomCoin;
			Coin findCoin = Coin.getCoinKeyNumber(randomCoin);
			coinMap.put(findCoin, coinMap.get(findCoin) + 1);
		}
	}


	public void beverage(ArrayList<String[]> goodsInput) {
		for (String[] beverageString : goodsInput) {
			Beverages.add(new Beverage(beverageString));
		}

	}

	public int getBeveragePrice(String buyBeverage) {
		for (Beverage beverage : Beverages) {
			if (beverage.getName().equals(buyBeverage)) {
				beverage.sellBeverage();
				int price = beverage.getPrice();
				return price;
			}
		}
		try {
			Validater.notInBeverage();
		} catch (IllegalArgumentException e) {
			System.out.println(Validater.errorMassage);
		}
		return totalCoin;

	}

	public boolean coinReturn(int money) {
		int min = lowestPrice();
		boolean isMargin = beverageMargin();
		if (money < min || isMargin) {
			return false;
		}
		return true;
	}

	private int lowestPrice() {
		int min = BIG_NUMBER;
		for (Beverage beverage : Beverages) {
			min = Math.min(beverage.getPrice(), min);
		}
		return min;
	}

	private boolean beverageMargin() {
		for (Beverage beverage : Beverages) {
			if (beverage.count != 0) {
				return false;
			}
		}
		return true;

	}

	HashMap<Coin, Integer> lastChange(int finalMoney) {
		if (totalCoin <= finalMoney) {
			return coinMap;
		}
		for (Coin money : Coin.values()) {
			greedyChange(finalMoney, money);
		}
		return greedyMap;
	}

	// 그리디 잔돈
	private void greedyChange(int finalMoney, Coin money) {

		if (coinMap.get(money) > 0 || money.getAmount() < finalMoney) {
			int cnt = (int) (finalMoney / money.getAmount());
			coinMap.put(money, coinMap.get(money) - cnt);
			finalMoney -= (coinMap.get(money) * cnt);
			greedyMap.put(money, cnt);
		}

	}

}
