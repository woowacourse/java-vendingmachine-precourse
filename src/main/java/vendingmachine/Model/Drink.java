package vendingmachine.Model;

public class Drink {
    private static String name;
    private static int price;
    private static int stock;

    public Drink(String name, int price, int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }
}
