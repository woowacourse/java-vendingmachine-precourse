package vendingmachine;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {

		String changs = Input.MachineCashInput();
		VendingMachine DrinkVM = new VendingMachine(changs);
		Output.hasCoinPrint(DrinkVM.coinMap);

		ArrayList<String[]> goodsInfo = Input.goodsInput();
		DrinkVM.beverage(goodsInfo);

		String money = Input.cashInput();
		MoneyInput Money = new MoneyInput(money);

		while (DrinkVM.coinReturn(Money.getMoney())) {
			Output.inputMoneyPrint(Money.getMoney());
			String buyGoods = Input.buyGoodsInput();
			int buyBPrice = DrinkVM.getBeveragePrice(buyGoods);
			Money.remainMoney(buyBPrice);
		}
		int finalMoney = Money.getMoney();
		Output.inputMoneyPrint(finalMoney);
		Output.changesPrint(DrinkVM.lastChange(finalMoney));

	}

}
