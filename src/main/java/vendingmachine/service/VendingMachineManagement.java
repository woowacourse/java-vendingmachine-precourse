package vendingmachine.service;

import static vendingmachine.view.Print.*;

import vendingmachine.domain.VendingMachine;

public class VendingMachineManagement {
	private VendingMachine vendingMachine;

	public VendingMachineManagement(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void noticeInsertMoneyOfChanges() {
		printInsertMoneyOfChanges();
	}

	public void insertMoneyOfChanges(int money) {
		vendingMachine.setChanges(money);
	}

	public void noticeCountOfCoins() {
		printCountOfCoinsTitle();
		vendingMachine.noticeCountOfCoins();
	}

	// 자판기가 가지는 상품 정보 검증

	// 상품 정보 파싱하여 자판기에 전달

	// 자판기 거래 관련

	// 투입 금액 검증

	// 구매할 수 있는 상황인지 확인

	// 구매하는 상품 정보 검증

	// 구매하는 상품 이름 자판기에 전달

	// 잔돈 반환
}
