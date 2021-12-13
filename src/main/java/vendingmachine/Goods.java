package vendingmachine;

public class Goods {
    private final String name;
    private final int price;
    private final int quantity;

    public Goods(String namePriceQuantity) {
        String[] goodsInfo = namePriceQuantity.split(",");

        this.name = goodsInfo[0];
        this.price = Integer.parseInt(goodsInfo[1]);
        this.quantity = Integer.parseInt(goodsInfo[2]);
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
}
