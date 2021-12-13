package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static String MachineCashInput() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		String MachineCashInput = Console.readLine();
		return MachineCashInput;
	}
	
	public static String goodsInput() {
    	System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    	System.out.println("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해 주세요.");
    	
		String goodsInput = Console.readLine();
		return goodsInput;
		
	}
	
	public static String cashInput() {
    	System.out.println("투입 금액을 입력해 주세요.");
    	String cashInput = Console.readLine();
    	return cashInput;
	}

	
	public static String buyGoodsInput() {
    	System.out.println("구매할 상품명을 입력해 주세요.");
    	String buyGoodsInput =  Console.readLine();
		return buyGoodsInput;
	}
	
	
	


	
}
