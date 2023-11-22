package vendingmachine.model.drink;

public class Drink {
    private String title;
    private Integer price;
    private Integer count;

    public Drink(String title, Integer price, Integer count) {
        this.title = title;
        this.price = price;
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }
}
