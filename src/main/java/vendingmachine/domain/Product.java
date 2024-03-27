package vendingmachine.domain;

public class Product {
    private final String name;
    private final int cost;
    private final int count;

    public Product (String name, int cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getCount() {
        return this.count;
    }

    public Product buyOne() {
        if(count==0) throw new IllegalArgumentException("[ERROR] 소진된 상품이다.");
        return new Product(name, cost, count-1);
    }
}
