package vendingmachine;

import java.util.HashMap;

public class VendingMachinePrinter {
	public static void printGetAmountMessage(MoneyType moneyType){
		if(moneyType == MoneyType.leftMoney){
			System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		}
		else if(moneyType == MoneyType.inputAmount){
			System.out.println("투입 금액을 입력해 주세요.");
		}
	}

	public static void printGetProductNameMessage(int inputAmount){
		System.out.println("투입 금액: " + inputAmount + "원");
		System.out.println("구매할 상품명을 입력해 주세요.");
	}

	public static void printCurrentCoins(HashMap<Coin, Integer> coins){
		System.out.println("자판기가 보유한 동전");
		for(Coin coin : Coin.values()){
			System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
		}
	}
	public static void printGetProductInfoMessage(){
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
	}

	public static void printChanges(HashMap<Coin, Integer> changes, int inputAmount){
		System.out.println("투입 금액: " + inputAmount + "원");
		System.out.println("잔돈");

		for(Coin coin : Coin.values()){
			if(changes.get(coin) == 0){
				continue;
			}
			System.out.println(coin.getAmount() + "원 - " + changes.get(coin) + "개");
		}
	}
}
