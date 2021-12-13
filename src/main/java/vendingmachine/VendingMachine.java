package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	int totalCoin;
	HashMap<Coin, Integer> coinMap = new HashMap<>();
	static ArrayList<Beverage> Beverages = new ArrayList<>();

	public VendingMachine(String cash) {
		this.totalCoin = ValidTotalCoin(cash);
		init();
		makeRandomCoin();
	}

	private void init() {
		for (Coin money : Coin.values()) {
			coinMap.put(money, 0);
		}
	}
	
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
	

	public static void beverage(String goodsInput) {
		isSemicolon(goodsInput);
		String[] goodsList = goodsInput.split(";");

		for (String beverageString : goodsList) {
			Beverages.add(new Beverage(beverageString));
		}

	}


	// 예외처리
	private int ValidTotalCoin(String cash) {
		if (!cash.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
		int totalCoin = Integer.parseInt(cash);
		DivideTen(totalCoin);
		return totalCoin;
	}

	private void DivideTen(int totalCoin) {
		if (totalCoin % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나눠져야 합니다.");
		}
	}
	
	private static void isSemicolon(String goodsInput) {
		if (!goodsInput.matches("[;]")) {
			throw new IllegalArgumentException("옳바른 입력값이 아닙니다.");
		}
	}

	
	// 자판기 출력은 별도 클래스로 이동

}
