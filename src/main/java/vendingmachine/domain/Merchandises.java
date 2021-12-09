package vendingmachine.domain;

import java.util.List;

public class Merchandises {
	private List<Merchandise> merchandiseList;

	public Merchandises(List<Merchandise> merchandiseList) {
		this.merchandiseList = merchandiseList;
	}

	public List<Merchandise> getMerchandiseList() {
		return merchandiseList;
	}
}
