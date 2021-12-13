package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import vendingmachine.utils.Validator;

public class Merchandise {
	public static String MERCHANDISE_INFORMATION_PARSER = ",";
	public static String MERCHANDISE_PARSER = ";";

	private final Name name;
	private final Money money;
	private final Quantity quantity;

	public Merchandise(Name name, Money money, Quantity quantity) {
		this.name = name;
		this.money = money;
		this.quantity = quantity;
	}

	public Money getMoney() {
		return money;
	}

	public static Merchandise constructMerchandise(String merchandiseInforamtion) {
		String[] informations = merchandiseInforamtion.split(MERCHANDISE_INFORMATION_PARSER);
		Validator.validateEmptyMerchandiseInformation(informations);
		Validator.validateDivideMoneyBy10Coin(Integer.parseInt(informations[1].trim()));
		return new Merchandise(new Name(informations[0].trim()), new Money(Integer.parseInt(informations[1].trim())),
			new Quantity(Integer.parseInt(informations[2].trim())));
	}

	public static List<Merchandise> constructMerchandises(String merchandiseInformations) {
		List<Merchandise> merchandiseList = new ArrayList<>();
		for (String merchandiseInformation : merchandiseInformations.split(MERCHANDISE_PARSER)) {
			Validator.validateInputMerchandise(merchandiseInformation);
			String merchandise = merchandiseInformation.substring(1, merchandiseInformation.length() - 1).trim();
			merchandiseList.add(constructMerchandise(merchandise));
		}
		return merchandiseList;
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Merchandise that = (Merchandise)o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
