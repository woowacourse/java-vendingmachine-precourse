package vendingmachine.domain;

import static vendingmachine.domain.Merchandise.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.utils.ErrorMessage;
import vendingmachine.utils.Validator;

public class Merchandises {
	private List<Merchandise> merchandiseList;

	public Merchandises(List<Merchandise> merchandiseList) {
		Validator.validateDuplicateMerchandise(merchandiseList);
		this.merchandiseList = merchandiseList;
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

	public Merchandise selectMerchandise(String merchandiseName) {
		Merchandise merchandise = merchandiseList.stream()
			.filter(sellMerchandise -> sellMerchandise.isEqualsName(merchandiseName))
			.findFirst()
			.orElseThrow(
				() -> new IllegalArgumentException(ErrorMessage.INVALID_NO_STOCK_MERCHANDISE_BUY_ERROR_MESSAGE));
		return merchandise;
	}

	public boolean isAllMerchandisesSoldOut() {
		List<Merchandise> soldOutMerchandises = merchandiseList.stream()
			.filter(merchandise -> merchandise.isMerchandiseSoldOut())
			.collect(Collectors.toList());

		return soldOutMerchandises.size() == merchandiseList.size();
	}

	public List<Merchandise> selectExpensiveMerchandise(int userMoney) {
		return merchandiseList.stream()
			.filter(merchandise -> merchandise.isBigMerchandiseMoney(userMoney))
			.collect(Collectors.toList());
	}

	public int getMerchandisesSize() {
		return merchandiseList.size();
	}
}
