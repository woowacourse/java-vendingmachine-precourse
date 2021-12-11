package vendingmachine;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool;

public class InputManager {
    public static final String PREFIX_ERROR = "[ERROR]";

    public VendingMachine setVendingMachine() {
        while(true) {
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            String inputData = Console.readLine();
            System.out.println();
            try {
                return new VendingMachine(Validators.validateAmount(inputData));
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 0 또는 자연수만 입력 가능합니다.");
            }
        }
    }


}
