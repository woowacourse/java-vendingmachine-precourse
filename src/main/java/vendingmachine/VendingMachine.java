package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	int totalCoin;

	HashMap<Coin, Integer> coinMap = new HashMap<>();
	HashMap<Coin, Integer> greedyMap = new HashMap<>();
	static ArrayList<Beverage> Beverages = new ArrayList<>();

	public VendingMachine(String cash) {

		Validater.isNumberCheck(cash);
		Validater.isDivideTen(cash);
		Validater.isZeroCheck(cash);

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

	// 음료 추가
	public void beverage(String goodsInput) {
		// Validater.isSemicolon(goodsInput);
		String[] goodsList = goodsInput.split(";");

		for (String beverageString : goodsList) {
			Beverages.add(new Beverage(beverageString));
		}

	}

	// 음료찾아 차감하기
	public int getBeveragePrice(String buyBeverage) {
		for (Beverage beverage : Beverages) {
			if (beverage.getName().equals(buyBeverage)) {
				beverage.sellBeverage();
				int price = beverage.getPrice();// 투입금액 차감
				return price;
			}
		}
		throw new IllegalArgumentException("자판기에 없는 음료입니다.");
	}

	// 잔돈 반환 (최저가보다 적거나, 수량이 모두 다한 경우)
	public boolean coinReturn(int money) {
		int min = lowestPrice();
		boolean isMargin = beverageMargin();
		if (money < min || isMargin) {
			return false;
		}
		return true;
	}

	// 최저가 찾기
	private int lowestPrice() {
		int min = 9999999;
		for (Beverage beverage : Beverages) {
			min = Math.min(beverage.getPrice(), min);
		}
		return min;
	}

	// 수량확인하기
	private boolean beverageMargin() {
		for (Beverage beverage : Beverages) {
			if (beverage.count != 0) {
				return false;
			}
		}
		return true;

	}

	// 잔돈 처리
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
