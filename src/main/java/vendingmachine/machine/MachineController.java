package vendingmachine.machine;

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

    public void initMachine() {
        machine = new Machine(inputMoney(MachineView.inputMoney()));

        boolean result = false;
        do{
            result = playMachine();
        }while (!result);

        coinController.showLeftMoney(machine.getInputMoney());
    }

    // 게임이 종료된다 -> true
    public boolean playMachine() {

        // 투입 금액을 일단 출력해
        System.out.println(machine.toString());

        // 그리고 남은 가격으로 파악
        if(checkLeftItem()){
            return true;
        }

        String product = MachineView.inputItem();

        // 예외 처리
        // 상품 입력해서 만약 없는 상품을 입력했다면 재 입력 시키기.
        // 재고가 0인거 시키면 재고 0이라고 다른 거 시키라고 입력 시키기.

        // 그 외 맞는 거 들어오면 재고 -1 + 남은 금액 - 하기
        buyItem(findItemByName(product));
        return false;

    }

    // 재고가 0이 아닐때
    public void buyItem(Item item) {
        item.minusCount();
        machine.renewLeftMoney(item.getPrice());
    }


    // 원하는 아이템에 대한 정보 찾기
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

        // 이러면 갱신된 것이 없다는 뜻이므로
        if(minPrice == 0) {
            minPrice = Integer.MAX_VALUE;
        }
        return minPrice;
    }

    public int inputMoney(String stringMoney) {
        // 여기서 돈이 음수인지와 숫자가 아닌 다른 문자가 섞였는지 파악한다.

        int money = Integer.parseInt(stringMoney);
        return money;
    }



}
