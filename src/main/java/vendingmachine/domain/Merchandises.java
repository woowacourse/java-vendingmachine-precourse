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

	public Merchandise selectMerchandise(String merchandiseName) {
		for (Merchandise merchandise : merchandiseList) {
			if (merchandise.getName().equals(merchandiseName)) {
				return merchandise;
			}
		}
		return null;
	}
}
