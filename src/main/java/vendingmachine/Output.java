package vendingmachine;

public class Output {

	
	
	//자판기가 보유한 잔돈 출력 
	private void hasCoinPrint(/*배열값으로 받기*/ ) {
		System.out.print("자판기가 보유한 동전");
		// 배열 풀어서 출력하기
		//if(int  a: )
		System.out.println("원");

	}//현재 투입금액 상태 출력
	public static void inputMoneyPrint(int inputMoney) {
		System.out.print("투입 금액: ");
		System.out.println(inputMoney + "원");
		//System.out.println("구매할 상품명을 입력해 주세요.");
	}
	
	//거슬러주는 잔돈 출력
	public static void changesPrint(/*배열값으로 받기*/) {
		System.out.println("잔돈");
		//배열을 풀어서 프린트하기 
		
	} 
}
