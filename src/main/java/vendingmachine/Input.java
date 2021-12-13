package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static String MachineCashInput() {
		String MachineCashInput;
		while (true) {
			System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
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
			System.out.println("상품명과 가격, 수량을 입력해 주세요.");
			System.out.println("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해 주세요.");
			goodsInput = Console.readLine();
			try {
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("");
			}
		}
		return goodsInput;

	}

	public static String cashInput() {
		String cashInput;
		while (true) {
			System.out.println("투입 금액을 입력해 주세요.");
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
		System.out.println("구매할 상품명을 입력해 주세요.");
		String buyGoodsInput = Console.readLine();
		return buyGoodsInput;
	}

}
