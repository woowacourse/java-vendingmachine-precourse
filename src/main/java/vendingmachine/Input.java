package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	final static String ENTER_MONEY_IN_VENDINGMACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	final static String ENTER_GOODS_INFOMATION = "상품명과 가격, 수량을 입력해 주세요.";
	final static String ENTER_GOODS_INFOMATION_METHOD = "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해 주세요.";
	final static String ENTER_INPUT_MONEY = "투입 금액을 입력해 주세요.";
	final static String ENTER_BUY_GOODS = "구매할 상품명을 입력해 주세요.";

	public static String MachineCashInput() {
		String MachineCashInput;
		while (true) {
			System.out.println(ENTER_MONEY_IN_VENDINGMACHINE);
			MachineCashInput = Console.readLine();
			try {
				Validater.isNumberCheck(MachineCashInput);
				Validater.isDivideTen(MachineCashInput);
				Validater.isZeroCheck(MachineCashInput);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(Validater.errorMassage);
			}
		}
		return MachineCashInput;
	}

	public static String goodsInput() {
		String goodsInput;
		while (true) {
			System.out.println(ENTER_GOODS_INFOMATION);
			System.out.println(ENTER_GOODS_INFOMATION_METHOD);
			goodsInput = Console.readLine();
			try {
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(Validater.errorMassage);
			}
		}
		return goodsInput;

	}

	public static String cashInput() {
		String cashInput;
		while (true) {
			System.out.println(ENTER_INPUT_MONEY);
			cashInput = Console.readLine();
			try {
				Validater.isNumberCheck(cashInput);
				Validater.isDivideTen(cashInput);
				Validater.isZeroCheck(cashInput);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(Validater.errorMassage);
			}
		}
		return cashInput;
	}

	public static String buyGoodsInput() {
		System.out.println(ENTER_BUY_GOODS);
		String buyGoodsInput = Console.readLine();
		return buyGoodsInput;
	}

}
