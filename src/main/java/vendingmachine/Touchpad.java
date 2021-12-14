package vendingmachine;

import static java.util.Arrays.asList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Touchpad {

    public int insertVendingMachineAsset() {
        return Integer.parseInt(Console.readLine());
    }

    public List<String> inputProducts() {
        return asList(Console.readLine().split(";"));

    }

    public int insertMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public String purchaseProduct() {
        return Console.readLine();
    }
}
