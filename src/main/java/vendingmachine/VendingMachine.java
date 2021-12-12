package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	int totalCoin;
	HashMap<Coin, Integer> coinMap =new HashMap<>();
	
	

	public VendingMachine(String cash) {
		this.totalCoin = ValidTotalCoin(cash);
		init();
		makeRandomCoin();
	}
	
	
	private void makeRandomCoin() {
		int remainCoin=0;
		while(remainCoin != totalCoin) {
			int randomCoin = Randoms.pickNumberInList(Coin.coinList());
			if((remainCoin + randomCoin) > totalCoin){
				continue;
			}
			remainCoin += randomCoin;
			Coin findCoin =Coin.getCoinKeyNumber(randomCoin);
			coinMap.put(findCoin, coinMap.get(findCoin)+ 1);
		}
	}
	
	
	
	private void init(){
    	for(Coin money : Coin.values()){
    	    coinMap.put(money,0);
        }
	}

	

	
	
	//예외처리 
	private int ValidTotalCoin(String cash){
		if(!cash.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
		int totalCoin = Integer.parseInt(cash);
		DivideTen(totalCoin);
		return totalCoin;
	}
	
	private void DivideTen(int totalCoin){
		if(totalCoin % 10 != 0 ) {
			throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나눠져야 합니다.");	
		}	
	}
	
	
	/* 구현전 내용 */ 
	
	//자판기에 상품명,가격 수량을 추가하기
	
	//자판기 출력은 별도 클래스로 이동
	
}
