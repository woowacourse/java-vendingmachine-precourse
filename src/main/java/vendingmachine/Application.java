package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public static Items getItems() {
        String[] itemStatuses = InputView.getItemStatuses().split(";");
        Items items = new Items();
        for (String itemStatus : itemStatuses) {
            items.addItem(itemStatus);
        }
        return items;
    }
}
