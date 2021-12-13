package vendingmachine;
import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	
	
	public static String goodsInput() {
    	System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    	System.out.println("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해 주세요.");
    	
		String goodsInput = Console.readLine();
		return goodsInput;
		
	}
	
	public static ArrayList<Beverage> beverage(String goodsInput){
		isSemicolon(goodsInput);
		String[] goodsList = goodsInput.split(";");
		ArrayList<Beverage> Beverages =new ArrayList<>();
		for(String beverageString : goodsList) {
			Beverages.add(new Beverage(beverageString));
		}
		
		return Beverages;
		 
	}

	private static void isSemicolon(String goodsInput) {
		if(!goodsInput.matches("[;]")) {
			throw new IllegalArgumentException("옳바른 입력값이 아닙니다.");
		}
	}

	
}
