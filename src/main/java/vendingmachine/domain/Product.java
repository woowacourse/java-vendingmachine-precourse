package vendingmachine.domain;

public class Product {
    private String name;
    private Integer price;
    private Integer count;

    public Product(String name, Integer price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }


    public void print() {
        System.out.println("name : " + name);
        System.out.println("price : " + price);
        System.out.println("count : " + count);

    }
}
