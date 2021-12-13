package vendingmachine.model;

public class Product {
    private static final String BUY_ERROR_SENTENCE = "[ERROR] 상품을 구매할 수 없습니다.";
    private static final int PRODUCT_NAME = 0;
    private static final int PRODUCT_PRICE = 1;
    private static final int PRODUCT_STOCK = 2;
    private static final int MIN_STOCK = 0;

    private String name;
    private int price;
    private int stock;

    public Product(String[] productInfo) {
        this.name = productInfo[PRODUCT_NAME];
        this.price = Integer.parseInt(productInfo[PRODUCT_PRICE]);
        this.stock = Integer.parseInt(productInfo[PRODUCT_STOCK]);
    }

    public boolean isSameProduct(String name) {
        return this.name.equals(name);
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isNotSoldOut() {
        return stock != MIN_STOCK;
    }

    public void buy(int payment) {
        if (price > payment || stock <= MIN_STOCK) {
            throw new IllegalStateException(BUY_ERROR_SENTENCE);
        }
        stock--;
    }
}
