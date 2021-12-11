package vendingmachine.domain;

import java.util.HashMap;

public class VendingMachine {
	private HashMap<Coin, Integer> changes = new HashMap<>(Coin.values().length);
	private HashMap<Product, Integer> products = new HashMap<>();
	private int money;

	// 보유하는 금액을 받아 동전 개수 정하기

	// 동전 정보 저장

	// 상품 정보 저장
	
	// 투입 금액 정보 저장

	// 구매한 상품 정보 개수 및 투입 금액 차감

	// 잔돈 정보 반환
}
