package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import vendingmachine.utils.Validator;

public class Merchandise {
	public static String MERCHANDISE_INFORMATION_PARSER = ",";
	public static String MERCHANDISE_PARSER = ";";

	private final String name;
	private final Money money;
	private Quantity quantity;

	public Merchandise(String name, Money money, Quantity quantity) {
		Validator.validateEmptyMerchandiseName(name);
		this.name = name;
		this.money = money;
		this.quantity = quantity;
	}

	public Money getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}


	public static Merchandise constructMerchandise(String merchandiseInforamtion) {
		String[] informations = merchandiseInforamtion.split(MERCHANDISE_INFORMATION_PARSER);
		Validator.validateEmptyMerchandiseInformation(informations);
		Validator.validateDivideMoneyBy10Coin(Integer.parseInt(informations[1].trim()));
		return new Merchandise(informations[0].trim(), new Money(Integer.parseInt(informations[1].trim())),
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
