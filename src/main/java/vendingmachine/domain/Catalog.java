package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.repository.UserAccount;

public class Catalog {
	private String name;
	private int price;
	private int amount;

	public Catalog(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Catalog catalog = (Catalog)obj;
		return Objects.equals(name, catalog.name);
	}

	public void purchase() {
		this.amount--;
		UserAccount.purchase(this.price);
	}

	public boolean isCheaperThan(int userAccount) {
		return price <= userAccount;
	}

	public boolean isExist() {
		return amount > 0;
	}
}
