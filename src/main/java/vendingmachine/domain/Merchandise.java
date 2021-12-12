package vendingmachine.domain;

public class Merchandise {
    public String name;
    public int price;
    public int number;

    public Merchandise(String merchandiseInfo) {
        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(",");
        this.name = infoList[0];
        this.price = Integer.parseInt(infoList[1]);
        this.number = Integer.parseInt(infoList[2]);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void decreaseNumber() {
        this.number--;
    }
}
