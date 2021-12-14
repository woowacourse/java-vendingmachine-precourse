package vendingmachine;

public class Menu {
    private final String name;
    private final int price;
    private int left;

    public Menu(String name, int price, int left){
        this.name = name;
        this.price = price;
        this.left = left;
    }

    public void buy(){
        left--;
    }

    public boolean isName(String newName){
        return this.name.equals(newName);
    }

    public boolean isLeft(){
        return left > 0;
    }

    public int smallerPrice(int otherPrice){
        if ((otherPrice != -1)&&(this.price > otherPrice)) {
            return otherPrice;
        }

        return this.price;
    }

    public int getPrice(){
        return this.price;
    }

}
