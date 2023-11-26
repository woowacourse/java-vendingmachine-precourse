package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.VendingMachineStatusDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//원래라고 하면 자판기에 보유금액, Products까지 속성으로 되어야할것같은데.. << 이러려면 set이 필요하거나
//생성자 주입으로 되지 못해.. 애초에 보유금액 입력 후 동전내역이 출력된후 상품 정보를입력받는 순서이기 때문에
//다른 사람들은 어떻게 한거지..?

public class VendingMachine {
    private final HashMap<Coin, Integer> vendingMachine;

    public VendingMachine(){
        vendingMachine = new HashMap<>();
        init();
    }

    private void init(){
        for (Coin coin : Coin.values()) {
            vendingMachine.put(coin, 0);
        }
    }

    public void addCoins(Coin coin, int count) {
        vendingMachine.put(coin, vendingMachine.get(coin) + count);
    }
}
