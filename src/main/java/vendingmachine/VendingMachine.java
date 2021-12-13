package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	int totalCoin;
	HashMap<Coin, Integer> coinMap = new HashMap<>();
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
	
	
	//랜덤 코인 생성
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
	
	
	//음료 추가
	public static void beverage(String goodsInput) {
		Validater.isSemicolon(goodsInput);
		String[] goodsList = goodsInput.split(";");

		for (String beverageString : goodsList) {
			Beverages.add(new Beverage(beverageString));
		}

	}
	
	//음료 리스트 뽑기 
	public static String[] getBeverageName() {
		String[] beverageNames = new String[Beverages.size()];
		int idx = 0;
		for(Beverage beverage :Beverages) {
			beverageNames[idx] = beverage.getName();
			idx ++;
		}
		
		return beverageNames;
	}
	
	
	
	//음료 관리 
	public static void isBeverageCheck(String buyBeverage) throws IllegalAccessException {
			String[] beverageNames = getBeverageName();
			boolean check = false;
			for(String name : beverageNames) {
				if(name == buyBeverage) {
					check= true;
				}	
			}
			if(!check) {
				throw new IllegalAccessException("자판기에 없는 음료입니다.");		
			}
		
	}

	

	/* 예외 별도 클래스 처리 */

	
	/* 구현전 내용 */
	
	// 자판기 출력은 별도 클래스로 이동

}
