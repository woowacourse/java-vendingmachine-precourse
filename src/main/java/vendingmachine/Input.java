package vendingmachine;
import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	
	
	public static String goodsInput() {
    	System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    	System.out.println("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해 주세요.");
    	
		String goodsInfo = Console.readLine();
		return goodsInfo;
		
	}
	
	public static String beverage(String goodsInfo){
		//대괄호 제거
		goodsInfo= goodsInfo.replaceAll("\\]", "");
		goodsInfo= goodsInfo.replaceAll("\\[", "");
		
		String[] goodsList = goodsInfo.split(";");
		 ArrayList<Beverage>  Beverages = Beverages(goodsList);
		
		 /* 테스트
		System.out.println(Beverages.get(0).getName());
		System.out.println(Beverages.get(1).getName());
		*/
		return null;
		 
	}
	
	private static ArrayList<Beverage> Beverages(String[] goodsList){
		ArrayList<Beverage> Beverages = new ArrayList<>(); 
		for(String goods : goodsList) {
			String[] beverageInfo = goods.split(",");
			String name = beverageInfo[0];
			String stringPrice = beverageInfo[1];
			String stringCount = beverageInfo[2];
			//price 랑 count 올바른 값인지 체크 필요!!!
			int price = Integer.parseInt(stringPrice);
			int count = Integer.parseInt(stringCount);			
			Beverages.add(new Beverage(name, price, count));
		}
		
		return null;
	}
	
}
