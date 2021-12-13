package vendingmachine;

public class Goods {
    private static final int GOODS_SIZE = 3;
    private static final String INFO_MISSED_MESSAGE = "상품명,가격,수량 순으로 누락 없이 작성해주세요.";

    private final String name;
    private final GoodsPrice price;
    private final GoodsQuantity quantity;

    public Goods(String namePriceQuantity) {
        validateInfoNotMissed(namePriceQuantity);
        String[] goodsInfo = namePriceQuantity.split(",");

        String name = goodsInfo[0];
        String priceString = goodsInfo[1];
        String quantityString = goodsInfo[2];

        this.name = name;
        this.price = new GoodsPrice(priceString);
        this.quantity = new GoodsQuantity(quantityString);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    private void validateInfoNotMissed(String goodsInfo) {
        if (isInfoMissed(goodsInfo.split(","))) {
            throw new IllegalArgumentException(INFO_MISSED_MESSAGE);
        }
    }

    private boolean isInfoMissed(String[] goodsInfo) {
        return goodsInfo.length < GOODS_SIZE;
    }
}
