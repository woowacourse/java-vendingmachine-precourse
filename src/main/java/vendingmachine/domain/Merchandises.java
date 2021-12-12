package vendingmachine.domain;

import java.util.List;
import java.util.stream.Stream;

import vendingmachine.utils.ErrorMessage;
import vendingmachine.utils.Validator;

public class Merchandises {
	private List<Merchandise> merchandiseList;

	public Merchandises(List<Merchandise> merchandiseList) {
		Validator.validateDuplicateMerchandise(merchandiseList);
		this.merchandiseList = merchandiseList;
	}

	public List<Merchandise> getMerchandiseList() {
		return merchandiseList;
	}

	public Merchandise selectMerchandise(String merchandiseName) {
		Merchandise merchandise = merchandiseList.stream()
			.filter(sellMerchandise -> sellMerchandise.getName().equals(merchandiseName))
			.findFirst()
			.orElseThrow(
				() -> new IllegalArgumentException(ErrorMessage.INVALID_NO_STOCK_MERCHANDISE_BUY_ERROR_MESSAGE));
		return merchandise;
	}

}
