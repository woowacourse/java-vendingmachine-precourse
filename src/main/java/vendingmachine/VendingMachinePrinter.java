package vendingmachine;

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
		System.out.println("투입금액: " + inputAmount + "원");
		System.out.println("구매할 상품명을 입력해 주세요.");
	}


}
