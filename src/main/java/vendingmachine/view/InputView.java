package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.Money;
import vendingmachine.domain.Name;
import vendingmachine.domain.Products;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductsDto;
import vendingmachine.dto.RequestSellProductDto;

public class InputView {
	private static final String REQUEST_HOLDING_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String REQUEST_REGISTER_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String REQUEST_INSERT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String REQUEST_SELL_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";

	public static RequestHoldingMoneyDto inputHoldingMoney() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE);
		Money money = new Money(readLine());
		System.out.println();
		return new RequestHoldingMoneyDto(money);
	}

	public static RequestRegisterProductsDto inputRegisterProducts() {
		System.out.println(REQUEST_REGISTER_PRODUCT_MESSAGE);
		Products products = new Products(readLine());
		System.out.println();
		return new RequestRegisterProductsDto(products);
	}

	public static RequestInsertMoneyDto inputInsertMoney() {
		System.out.println(REQUEST_INSERT_MONEY_MESSAGE);
		Money money = new Money(readLine());
		System.out.println();
		return new RequestInsertMoneyDto(money);
	}

	public static RequestSellProductDto inputSellProduct() {
		System.out.println(REQUEST_SELL_PRODUCT_MESSAGE);
		Name name = new Name(readLine());
		System.out.println();
		return new RequestSellProductDto(name);
	}
}
