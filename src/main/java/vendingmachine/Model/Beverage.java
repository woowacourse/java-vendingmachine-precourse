package vendingmachine.Model;

import vendingmachine.Utils.Validator.MoneyValidator;
import vendingmachine.Utils.Validator.NameValidator;
import vendingmachine.Utils.Validator.NumberValidator;

public class Beverage {
	public final String name;
	public final int price;
	private int stock;

	public Beverage(String[] values) {
		validate(values);
		this.name = values[0];
		this.price = Converter.getInt(values[1]);
		this.stock = Converter.getInt(values[2]);
	}

	private void validate(String[] values) {
		new NameValidator(values[0]);
		new MoneyValidator(values[1]);
		new NumberValidator(values[2]);
	}


	public void sell() {
		stock--;
	}

	public boolean isSoldOut() {
		return stock == 0;
	}
}
