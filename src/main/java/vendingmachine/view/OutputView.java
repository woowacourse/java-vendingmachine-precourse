package vendingmachine.view;

public class OutputView {
	private static final String INSERT_MONEY = "투입 금액: %d원";

	public void printInsertMoney(int insertMoney) {
		String insertMoneyMessage = String.format(INSERT_MONEY, insertMoney);
		System.out.println(insertMoneyMessage);
	}
}
