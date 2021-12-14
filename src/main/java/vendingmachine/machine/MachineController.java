package vendingmachine.machine;

import vendingmachine.Validation;
import vendingmachine.coin.CoinController;
import vendingmachine.item.Item;
import vendingmachine.item.ItemController;

import java.util.List;
import java.util.Collections;

public class MachineController {
    private ItemController itemController;
    private CoinController coinController;

    List<Item> items;

    private Machine machine;
    public void initMoneyAndItems() {
        coinController.result();
        items = itemController.initItmes();
        Collections.sort(items);
    }

    public MachineController() {
        this.itemController = new ItemController();
        this.coinController = new CoinController();
        initMoneyAndItems();
    }

    public int inputMoney(String stringMoney) {
        int money = 0;
        try{
            Validation.checkOnlyNumber(stringMoney);
            money = Integer.parseInt(stringMoney);
            Validation.isPositiveNumber(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 투입 금액 형태를 확인해주세요.");
            initMachine();
        }
        return money;
    }

    public void initMachine() {
        String stringInputMoney = MachineView.inputMoney();
        int inputMoney = inputMoney(stringInputMoney);
        machine = new Machine(inputMoney);
    }

    public void mainVendingMachine() {
        initMachine();
        boolean result = false;
        do{
            System.out.println(machine.toString());
            result = playMachine();
        }while (!result);
        coinController.showLeftMoney(machine.getInputMoney());
    }

    // 게임이 종료된다 -> true
    public boolean playMachine() {
        if(checkLeftItem()){
            return true;
        }
        String product;
        try {
            product = MachineView.inputItem();
            Item item = findItemByName(product);
            buyItem(item);
        } catch (IllegalArgumentException e) {
            System.out.println("없는 상품이거나 재고가 부족한 상품입니다. 다시 입력해주세요.");
            playMachine();
        }
        return false;
    }

    public void checkItemIsExist(Item item) {
        if(item == null || item.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


    public void buyItem(Item item) {
        item.minusCount();
        machine.renewLeftMoney(item.getPrice());
    }


    public Item findItemByName(String product) {
        for(Item i : items) {
            if(i.getName().equals(product)) {
                return i;
            }
        }
        return null;
    }

    // 최소비용보다 적어서 종료해야된다면 true
    public boolean checkLeftItem() {
        if(machine.isLack(minItemPrice())){
            return true;
        }
        return false;
    }

    public int minItemPrice() {
        int minPrice = 0;
        for(Item i : items) {
            if(!i.isEmpty()){
                minPrice = i.getPrice();
                break;
            }
        }
        if(minPrice == 0) {
            minPrice = Integer.MAX_VALUE;
        }
        return minPrice;
    }
}