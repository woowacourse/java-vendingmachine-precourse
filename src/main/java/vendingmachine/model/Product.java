package vendingmachine.model;

public class Product {
    private static final String BUY_ERROR_SENTENCE = "[ERROR] 상품을 구매할 수 없습니다.";

    private String name;
    private int price;
    private int stock;

    public Product(String[] productInfo) {
        this.name = productInfo[0];
        this.price = Integer.parseInt(productInfo[1]);
        this.stock = Integer.parseInt(productInfo[2]);
    }

    public boolean isSameProduct(String name) {
        return this.name.equals(name);
    }

    public boolean buy(int payment) {
        if (price > payment || stock <= 0) {
            System.out.println(BUY_ERROR_SENTENCE);
            return false;
        }
        stock--;
        return true;
    }
}
