package vendingmachine;


public class VendingMachine {
	

	int totalCoin;

	public VendingMachine(String cash) {
		int totalcoin = ValidTotalCoin(cash);
		this.totalCoin = totalcoin;
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
	//무작위로 잔돈 보유하기 
	
	//자판기에 상품명,가격 수량을 추가하기
	
	//자판기 출력은 별도 클래스로 이동
	
}
