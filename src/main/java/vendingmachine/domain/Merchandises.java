package vendingmachine.domain;

import static vendingmachine.domain.Merchandise.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.utils.ErrorMessage;

public class Merchandises {
	private List<Merchandise> merchandiseList;

	public Merchandises(List<Merchandise> merchandiseList) {
		validateDuplicateMerchandise(merchandiseList);
		this.merchandiseList = merchandiseList;
	}

	public static List<Merchandise> constructMerchandises(String merchandiseInformations) {
		List<Merchandise> merchandiseList = new ArrayList<>();
		for (String merchandiseInformation : merchandiseInformations.split(MERCHANDISE_PARSER)) {
			validateInputMerchandise(merchandiseInformation);
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
		merchandise.deductQuantity();
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

	public static void validateDuplicateMerchandise(List<Merchandise> merchandiseList) {
		Set<Merchandise> merchandiseSet = new HashSet<>(merchandiseList);
		if (merchandiseSet.size() != merchandiseList.size()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED_MERCHANDISE_ERROR_MESSAGE);
		}
	}

	public static void validateInputMerchandise(String merchandiseInformation) {
		if (!merchandiseInformation.contains("[") || !merchandiseInformation.contains("]")) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_INPUT_ERROR_MESSAGE);
		}
	}
}
