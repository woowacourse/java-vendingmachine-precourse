package vendingmachine;

public class Goods {
    private static final int GOODS_SIZE = 3;
    private static final int DIVISOR = 10;
    private static final int ZERO = 0;
    private static final int LEAST_PRICE = 100;
    private static final String INFO_MISSED_MESSAGE = "상품명,가격,수량 순으로 누락 없이 작성해주세요.";
    private static final String QUANTITY_NOT_NUMERIC_MESSAGE = "상품 수량은 정수만 입력 가능합니다.";
    private static final String PRICE_NOT_NUMERIC_MESSAGE = "상품 가격은 정수만 입력 가능합니다.";
    private static final String PRICE_LESS_THAN_LEAST_PRICE_MESSAGE = "상품 가격은 최소 100원 이상이어야 합니다.";
    private static final String PRICE_NOT_DIVIDABLE_BY_DIVISOR_MESSAGE = "상품 가격은 최소 10원 단위로 입력해야 합니다.";

    private final String name;
    private final int price;
    private final int quantity;

    public Goods(String namePriceQuantity) {
        String[] goodsInfo = namePriceQuantity.split(",");
        if (isInfoMissed(goodsInfo)) {
            throw new IllegalArgumentException(INFO_MISSED_MESSAGE);
        }

        this.name = goodsInfo[0];
        this.price = insertPrice(goodsInfo[1]);
        this.quantity = insertQuantity(goodsInfo[2]);
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    private int insertQuantity(String quantity) {
        if (!isNumeric(quantity)) {
            throw new IllegalArgumentException(QUANTITY_NOT_NUMERIC_MESSAGE);
        }
        return Integer.parseInt(quantity);
    }

    private boolean isNumeric(String goodsInfo) {
        return goodsInfo.chars().allMatch(Character::isDigit);
    }

    private int insertPrice(String priceString) {
        if (!isNumeric(priceString)) {
            throw new IllegalArgumentException(PRICE_NOT_NUMERIC_MESSAGE);
        }

        int price = Integer.parseInt(priceString);

        if (!isMoreThanLeastPrice(price)) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_LEAST_PRICE_MESSAGE);
        }
        if (!isDividableByDivisor(price)) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDABLE_BY_DIVISOR_MESSAGE);
        }
        return price;
    }

    private boolean isMoreThanLeastPrice(int price) {
        return price >= LEAST_PRICE;
    }

    private boolean isDividableByDivisor(int price) {
        return price % DIVISOR == ZERO;
    }

    private boolean isInfoMissed(String[] goodsInfo) {
        return goodsInfo.length < GOODS_SIZE;
    }
}
