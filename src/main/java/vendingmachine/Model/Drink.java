package vendingmachine.Model;

public class Drink {
    private static String name;
    private static int price;
    private static int amount;

    public Drink(String name, int price, int amount){
        this.name=name;
        this.price=price;
        this.amount=amount;
    }
}
