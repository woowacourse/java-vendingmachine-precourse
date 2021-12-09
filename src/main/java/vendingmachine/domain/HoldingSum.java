package vendingmachine.domain;

public class HoldingSum {

	private int holdingSum;

	public void set(String input) {
		//예외 처리 로직 추가하기
		this.holdingSum = Integer.valueOf(input);
	}

	public String toString() {
		return String.valueOf(holdingSum);
	}
}
