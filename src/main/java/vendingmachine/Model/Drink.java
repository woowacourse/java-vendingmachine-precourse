package vendingmachine.Model;

public class Drink {
    private String name;
    private int price;
    private int stock;

    public Drink(String name, int price, int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }
}
