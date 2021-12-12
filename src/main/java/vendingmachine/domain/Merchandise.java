package vendingmachine.domain;

public class Merchandise {
    public String name;
    public int price;
    public int number;

    public Merchandise(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }
}
