package vendingmachine.view;

import static vendingmachine.utils.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Machine;
import vendingmachine.utils.BuyItemValidator;
import vendingmachine.utils.ItemValidator;
import vendingmachine.utils.MoneyValidator;

public class InputView {
	public static final String REQUEST_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String REQUEST_ITEM_INFO = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String REQUEST_INPUT_MONEY = "투입 금액을 입력해 주세요.";
	public static final String REQUEST_BUY_ITEM = "구매할 상품명을 입력해 주세요.";

	private MoneyValidator moneyValidator = new MoneyValidator();
	private ItemValidator itemValidator = new ItemValidator();

	public int enterMachineMoney() {
		try {
			System.out.println(REQUEST_MACHINE_MONEY);
			String inputValue = Console.readLine();
			moneyValidator.validateMoney(inputValue);
			return Integer.parseInt(inputValue);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterMachineMoney();
		}
	}

	public String enterItems() {
		try {
			System.out.println(REQUEST_ITEM_INFO);
			String inputValue = Console.readLine();
			itemValidator.validateItems(inputValue);
			return inputValue;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return enterItems();
		}
	}

	public int enterInputMoney() {
		try {
			System.out.println("\n" + REQUEST_INPUT_MONEY);
			String inputValue = Console.readLine();
			moneyValidator.validateMoney(inputValue);
			return Integer.parseInt(inputValue);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterInputMoney();
		}
	}

	public String enterBuyItem(Machine machine, int inputMoney) {
		try {
			System.out.println("\n" + CURRENT_INPUT_MONEY + inputMoney + WON);
			System.out.println(REQUEST_BUY_ITEM);
			String inputValue = Console.readLine();
			BuyItemValidator.validateBuyItem(machine, inputValue, inputMoney);
			return inputValue;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterBuyItem(machine, inputMoney);
		}
	}
}
