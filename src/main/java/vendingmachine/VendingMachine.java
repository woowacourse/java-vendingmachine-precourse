package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.io.InputStream;
import java.io.OutputStream;

public class VendingMachine {
    private ProductManager productManager;
    private CashManager cashManager;

    public VendingMachine(
            ProductManager productManager,
            CashManager cashManager
    ) {
        this.productManager = productManager;
        this.cashManager = cashManager;
    }


}
