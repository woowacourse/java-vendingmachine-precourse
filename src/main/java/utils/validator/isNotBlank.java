package utils.validator;

public class isNotBlank implements Validator {
	public boolean run(StringBuilder input){
		String inputStr = input.toString().trim();
		// 상품 생성 시 발생할 수 있는 에러 (이름)
		if (inputStr.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 상품 이름이 공백으로 이루어져 있습니다.");
		}
		return true;
	}
}
