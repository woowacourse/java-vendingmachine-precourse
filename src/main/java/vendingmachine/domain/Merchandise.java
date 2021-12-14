package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import vendingmachine.utils.ErrorMessage;

public class Merchandise {
	public static String MERCHANDISE_INFORMATION_PARSER = ",";
	public static String MERCHANDISE_PARSER = ";";

	private final Name name;
	private final Money money;
	private final Quantity quantity;

	public Merchandise(String name, int money, int quantity) {
		this.name = new Name(name);
		this.money = new Money(money);
		this.quantity = new Quantity(quantity);
	}

	public static Merchandise constructMerchandise(String merchandiseInforamtion) {
		String[] informations = merchandiseInforamtion.split(MERCHANDISE_INFORMATION_PARSER);
		validateEmptyMerchandiseInformation(informations);
		validateDivideMoneyBy10Coin(Integer.parseInt(informations[1].trim()));
		List<String> trimInformation = Arrays.stream(informations)
			.map(information -> information.trim())
			.collect(Collectors.toList());
		return new Merchandise(trimInformation.get(0), Integer.parseInt(trimInformation.get(1)),
			Integer.parseInt(trimInformation.get(2)));
	}

	public int getMerchandiseMoney() {
		return money.getMoney();
	}

	public boolean isMerchandiseSoldOut() {
		return quantity.isQuantityZero();
	}

	public void deductQuantity() {
		quantity.decreaseQuantity();
	}

	public boolean isEqualsName(String anotherName) {
		return name.isSameName(anotherName);
	}

	public boolean isBigMerchandiseMoney(int anotherMoney) {
		return money.isBigMyMoney(anotherMoney);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Merchandise that = (Merchandise)obj;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public static void validateEmptyMerchandiseInformation(String[] merchandiseInformation) {
		if (merchandiseInformation.length < 3) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_INFORMATION_ERROR_MESSAGE);
		}
	}

	public static void validateDivideMoneyBy10Coin(int merchandisePrice) {
		if (merchandisePrice % 10 != 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_PRICE_NOT_DIVIDE_10_COIN_ERROR_MESSAGE);
		}
	}
}
