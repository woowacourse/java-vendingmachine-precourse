package vendingmachine;

public class Application {
	public static void main(String[] args) {

		String changs = Input.MachineCashInput();
		VendingMachine DrinkVM = new VendingMachine(changs);
		Output.hasCoinPrint(DrinkVM.coinMap);

		while (true) {
			try {
				String goodsInfo = Input.goodsInput();
				DrinkVM.beverage(goodsInfo);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(Validater.errorMassage);
			}
		}
		
		String money = Input.cashInput();
		MoneyInput Money = new MoneyInput(money);

		while (DrinkVM.coinReturn(Money.getMoney())) {
			try {
				Output.inputMoneyPrint(Money.getMoney());
				String buyGoods = Input.buyGoodsInput();
				int buyBPrice = DrinkVM.getBeveragePrice(buyGoods);
				Money.remainMoney(buyBPrice);
			} catch (IllegalArgumentException e) {
				System.out.println(Validater.errorMassage);
			}

		}
		int finalMoney = Money.getMoney();
		Output.inputMoneyPrint(finalMoney);
		Output.changesPrint(DrinkVM.lastChange(finalMoney));

	}

}
