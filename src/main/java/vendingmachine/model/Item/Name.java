package vendingmachine.model.Item;

import java.util.Objects;

import vendingmachine.model.buy.BuyItemName;

public class Name {
    String name;

    public Name(String itemName) {
        this.name = itemName;
    }

    public boolean sameName(String name) {
        return this.name.equals(name);
    }

    public boolean sameName(BuyItemName buyItemName) {
        return this.name.equals(buyItemName.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name name1 = (Name)o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
