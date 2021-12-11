package vendingmachine.model.order;

public class DrinkValidator {
    private static final String EMPTY_ERROR = "[ERROR] 상품 정보는 공백이 될 수 없습니다.";
    private static final String NAME_NUMBER_ERROR = "[ERROR] 상품명은 숫자가 될 수 없습니다.";
    private static final String PRICE_STRING_ERROR = "[ERROR] 가격은 숫자여야 합니다.";
    private static final String PRICE_MIN_VALUE_ERROR = "[ERROR] 가격은 100원 이상이어야 합니다.";
    private static final String PRICE_UNIT_ERROR = "[ERROR] 가격은 10원 단위로 나눠져야 합니다.";
    private static final String QUANTITY_MIN_VALUE_ERROR = "[ERROR] 상품 갯수는 음수가 될 수 없습니다.";
    private static final int PRICE_MIN_VALUE = 100;
    private static final int UNIT_VALUE = 10;
    private static final int REST_VALUE = 0;
    private static final int QUANTITY_MIN_VALUE = 0;

    public DrinkValidator(String name, String price, String quantity) {
        isNameValid(name);
        isPriceValid(price);
        isQuantity(quantity);
    }

    private boolean isPriceValid(String price) {
        isEmpty(price);
        if (!isNumeric(price)) {
            throw new IllegalArgumentException(PRICE_STRING_ERROR);
        }
        int priceInt = Integer.parseInt(price);
        isPriceRangeValid(priceInt);
        isUnitSplit(priceInt);
        return true;
    }

    private boolean isNameValid(String name) {
        isEmpty(name);
        isString(name);
        return true;
    }

    private boolean isQuantity(String quantity) {
        isEmpty(quantity);
        isNumeric(quantity);
        isQuantityRangeValid(Integer.parseInt(quantity));
        return true;
    }

    private boolean isPriceRangeValid(int price) {
        if (price < PRICE_MIN_VALUE) {
            throw new IllegalArgumentException(PRICE_MIN_VALUE_ERROR);
        }
        return true;
    }

    private boolean isQuantityRangeValid(int quantity) {
        if (quantity < QUANTITY_MIN_VALUE) {
            throw new IllegalArgumentException(QUANTITY_MIN_VALUE_ERROR);
        }
        return true;
    }

    private boolean isUnitSplit(int price) {
        if (price % UNIT_VALUE != REST_VALUE) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR);
        }
        return true;
    }

    private boolean isNumeric(String drinkValue) {
        try {
            Integer.parseInt(drinkValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isEmpty(String drinkValue) {
        if (drinkValue.isEmpty())
            throw new IllegalArgumentException(EMPTY_ERROR);
        return false;
    }

    private boolean isString(String name) {
        if (!isNumeric(name)) {
            throw new IllegalArgumentException(NAME_NUMBER_ERROR);
        }
        return true;
    }
}
