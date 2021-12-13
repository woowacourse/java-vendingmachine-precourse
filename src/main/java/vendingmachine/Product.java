package vendingmachine;

public class Product {
    private static final int GOODS_SIZE = 3;
    private static final String INFO_MISSED_MESSAGE = "상품명,가격,수량 순으로 누락 없이 작성해주세요.";

    private final String name;
    private final ProductPrice price;
    private final ProductQuantity quantity;

    public Product(String namePriceQuantity) {
        validateInfoNotMissed(namePriceQuantity);
        String[] goodsInfo = namePriceQuantity.split(",");

        String name = goodsInfo[0];
        String priceString = goodsInfo[1];
        String quantityString = goodsInfo[2];

        this.name = name;
        this.price = new ProductPrice(priceString);
        this.quantity = new ProductQuantity(quantityString);
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

    public boolean isName(String productName) {
        return name.equals(productName);
    }

    public void validateEnoughStock(int demandQuantity) {
        quantity.validateEnoughStock(demandQuantity);
    }

    public boolean isEnoughMoneyToBuy(int inputAmount) {
        return price.canBuy(inputAmount);
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
