package vendingmachine;



public class Application {
	public static void main(String[] args) {
		
		String changs = Input.MachineCashInput();
		VendingMachine VM = new VendingMachine(changs);
		Output.hasCoinPrint(VM.coinMap);

		// 출력 VM
		while (true) {
			try {
			String goodsInfo = Input.goodsInput();
			VM.beverage(goodsInfo);
			break;
			}catch (IllegalArgumentException e) {
				System.out.println("");
			}
		}
		// 투입금액
		String money = Input.cashInput();
		MoneyInput Money = new MoneyInput(money);

		while (VM.coinReturn(Money.getMoney())) {
			Output.inputMoneyPrint(Money.getMoney());

			// 구매할 상품
			String buyGoods = Input.buyGoodsInput();
			int buyBPrice = VM.getBeveragePrice(buyGoods);
			Money.remainMoney(buyBPrice);

		}
		int finalMoney = Money.getMoney();
		Output.inputMoneyPrint(finalMoney);
		Output.changesPrint(VM.lastChange(finalMoney));

	}

}
