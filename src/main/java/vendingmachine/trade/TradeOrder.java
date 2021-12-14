package vendingmachine.trade;

import vendingmachine.billing.Payments;
import vendingmachine.product.Product;

public class TradeOrder {
	private static final String ERROR_NOT_LEFT = "해당 상품의 재고가 부족하여 구매할 수 없습니다.";
	private static final String ERROR_NOT_ENOUGH_MONEY = "잔액 부족으로 해당 상품을 구매할 수 없습니다.";

	private Product product;
	private Payments payments;

	public TradeOrder(Product product, Payments payments) {
		this.product = product;
		this.payments = payments;
	}

	public void validate() {
		if (!product.isRemainStock()) {
			throw new IllegalArgumentException(ERROR_NOT_LEFT);
		}
		if (!product.isEnoughMoney(payments.getRemainMoney())) {
			throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
		}
	}

	public void complete() {
		payments.payFor(product.release());
	}
}
