package vendingmachine.model.Item;

public class Name {
    String name;

    public Name(String itemName) {
        this.name = itemName;
    }

    @Override
    public String toString() {
        return name;
    }
}
