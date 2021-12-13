package vendingmachine.service;

public class ProductValidator {

    public void isValid(String[] product) {
        isValidName(product[0]);
        isValidPrice(product[1]);
        isValidStock(product[2]);

    }

    public boolean isValidName(String name) {
        String nameRegex = "^[ㄱ-ㅎ가-힣a-zA-Z]*$";
        if (!name.matches(nameRegex)){
           throw new IllegalArgumentException("[ERROR] 상품 이름은 한글 혹은 알파벳으로만 이루어져야 합니다.");
        }
        return true;

    }

    public boolean isValidPrice(String price) {
        if (!isNumeric(price)) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 숫자여야 합니다.");
        }
        if (Integer.parseInt(price) % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10으로 나누어 떨어져야 합니다.");
        }
        if (Integer.parseInt(price) < 100) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상부터 시작해야합니다.");
        }
        return true;
    }

    public boolean isNumeric(String string) {
        String numericRegex = "[0-9]+";
        return string.matches(numericRegex);
    }

    public boolean isValidStock(String stock) {
        if (isNumeric(stock)) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 재고 갯수는 숫자여야 합니다.");
    }

}
