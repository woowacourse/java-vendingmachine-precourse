package vendingmachine.trade;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.billing.Payments;
import vendingmachine.product.Product;
import vendingmachine.product.ProductStorage;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Trade {
	private ProductStorage productStorage;
	private Payments payments;

	public Trade(ProductStorage productStorage, Payments payments) {
		this.productStorage = productStorage;
		this.payments = payments;
	}

	public void repeat() {
		while (productStorage.isSellable(payments.getRemainMoney())) {
			requestTrading();
		}
	}

	private void requestTrading() {
		try {
			OutputView.printRemainMoney(payments.getRemainMoney());
			InputView.printProductForBuyingMessage();
			orderProduct();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.printMessage(illegalArgumentException);
		}
	}

	private void orderProduct() {
		Product product = productStorage.findProductByName(Console.readLine());
		TradeOrder tradeOrder = new TradeOrder(product, payments);
		tradeOrder.validate();
		tradeOrder.complete();
	}
}

