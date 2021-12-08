package vendingmachine.service;

import static vendingmachine.service.OutputService.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.verification.Verification;

public class InputService {

	private static final String INPUT_VENDING_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_ITEMS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_USER_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String INPUT_ITEM_NAME_MESSAGE = "구매할 상품명을 입력해 주세요.";
	private static final String INPUT_MONEY_MESSAGE = "투입 금액: ";

	public int readMoneyOfVendingMachine() {
		while (true) {
			try {
				System.out.println(INPUT_VENDING_MACHINE_MONEY_MESSAGE);
				return Verification.ofMoney(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public List<Item> readItems() {
		while (true) {
			try {
				System.out.println(INPUT_ITEMS_MESSAGE);
				return Verification.ofItems(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int readMoneyOfUser() {
		while (true) {
			try {
				System.out.println(INPUT_USER_MONEY_MESSAGE);
				return Verification.ofUserMoney(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Item readItemName(int money) {
		while (true) {
			try {
				System.out.println(INPUT_MONEY_MESSAGE + money + WON);
				System.out.println(INPUT_ITEM_NAME_MESSAGE);
				return Verification.ofItemName(Console.readLine(), money);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
