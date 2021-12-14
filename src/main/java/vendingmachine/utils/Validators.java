package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public class Validators {
	public static final String DELIMETER = ";";

	public static void checkValidFormatOfMoney(String inputValue) {
		if (!(inputValue.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException("금액은 숫자만 입력해주세요.");
		}
	}

	public static void checkValidRangeMoney(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (!(1 <= number)) {
			throw new IllegalArgumentException("정상 범위(" + 1 + "~" + 2147483647 + ")가 아닙니다");
		}
	}

	public static void checkValidMoney(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (number % 10 != 0) {
			throw new IllegalArgumentException("10원 단위로 입력해주세요");
		}
	}

	public static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException("빈칸 입력은 허용하지 않는다.");
		}
	}

	public static void checkValidFirstValue(String inputValue, String delimeter) {
		if (inputValue.charAt(0) == delimeter.charAt(0)) {
			throw new IllegalArgumentException("정상적인 이름을 입력하세요.");
		}
	}

	public static void checkPatternOfProduct(String inputValue, String delimeter, String regex) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim) // [콜라,1500,20]   [사이다,1000,10]
			.collect(Collectors.toList());

		Pattern pattern = Pattern.compile(regex);

		boolean isMatched = splitedInputValue.stream()
			.allMatch(stringValue -> pattern.matcher(stringValue).find());

		if (!isMatched) {
			throw new IllegalArgumentException("패턴에 맞지 않는 입력입니다.");
		}

		System.out.println("패턴은 통과"); // TODO 로그

		boolean isValidAmount = splitedInputValue.stream()
			.mapToInt(stringValue -> {
				Matcher matcher = pattern.matcher(stringValue);
				if (matcher.find()) {
					String amount = matcher.group(2);
					return Integer.parseInt(amount);
				}
				return 0;
			})
			.allMatch(amount -> amount >= 100 && amount % 10 == 0); // 추출물검사

		if (!isValidAmount) {
			throw new IllegalArgumentException("상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.");
		}

		System.out.println("금액 검사까지 통과");  // TODO 로그
		boolean isValidCount = splitedInputValue.stream()
			.mapToInt(stringValue -> {
				Matcher matcher = pattern.matcher(stringValue);
				if (matcher.find()) {
					String count = matcher.group(3);
					return Integer.parseInt(count);
				}
				return 0;
			})
			.allMatch(count -> count >= 1); // 추출물검사

		if (!isValidCount) {
			throw new IllegalArgumentException("상품 갯수는 1개이상이어야한다.");
		}

		System.out.println("갯수 검사까지 통과");  // TODO 로그

		List<String> names = splitedInputValue.stream()
			.map(stringValue -> {
				Matcher matcher = pattern.matcher(stringValue);
				if (matcher.find()) {
					String name = matcher.group(1);
					return name;
				}
				return "";
			})
			.collect(Collectors.toList());
		boolean isDuplicatesOfName = names.stream()
			.distinct().count() != names.size();

		if (isDuplicatesOfName) {
			throw new IllegalArgumentException("같은 상품이 중복 입력되었습니다.");
		}

		// System.out.println("상품명(추출) 중복검사까지 통과");  // TODO 로그

	}

	public static void checkValidProduct(String inputValue) {
		//DB(countMap)속 구매하려고 할 때 검증
		//1) 존재 유무  검증
		VendingMachine vendingMachine = VendingMachine.getInstance();
		Product product = vendingMachine.findProductByName(inputValue);
		// System.out.println("검증끝");
		//존재유무 확인후 -> 추가 확인-> 갯수1개이상 유무
		//2) 1개이상 유무 검증
		if (!(vendingMachine.isProductAvailable(product))) {
			throw new IllegalArgumentException("해당 상품은 현재 0개 입니다.");
		}
	}

	public static void checkValidLengthOfProductName(String inputValue) {
		int inputValueLength = inputValue.length();
		if (!(1 <= inputValueLength)) {
			throw new IllegalArgumentException(1 + "~" + 2147483647 + " 글자 범위 내에서 입력하세요.");
		}
		;
	}

	public static void checkIncludeSpace(String inputValue) {
		if (inputValue.trim().contains(" ")) {
			throw new IllegalArgumentException("공백이 포함될 수 없습니다.");
		}
	}

	private static void checkValidFormatOfProductName(String inputValue) {
		if (inputValue.chars().anyMatch(Character::isDigit)) {
			throw new IllegalArgumentException("숫자는 허용하지 않습니다.");
		}
	}

	private static void checkDuplicatesOfProductName(String inputValue) {
		if (Arrays.stream(inputValue.trim().split("")).distinct().count() != inputValue.trim().length()) {
			throw new IllegalArgumentException("중복값을 입력할 수 없습니다.");
		}
	}
}
