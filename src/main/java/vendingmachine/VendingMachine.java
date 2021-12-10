package vendingmachine;


public class VendingMachine {
	

	int totalCoin;

	public VendingMachine(int cash) {
		if (ValidTotalCoin(cash)){
		this.totalCoin = cash;
		}
	}
	


	
	//예외처리 
	private boolean ValidTotalCoin(int cash) {
		if(cash % 10 == 0) {return true;}
		return false;
	}
	
	
	
	
	/* 구현전 내용 */
	//무작위로 잔돈 보유하기 
	
	//자판기에 상품명,가격 수량을 추가하기
	
	//자판기 출력은 별도 클래스로 이동
	
}
