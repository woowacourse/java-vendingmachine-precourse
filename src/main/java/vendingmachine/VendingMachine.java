package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

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

    public void run() {
        initVault();
        initProducts();
    }

    private void initVault() {
        while (true) {
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            try {
                String buffer = Console.readLine();
                Validator.validateInputCash(buffer);
                int amount = Integer.parseInt(buffer);
                this.cashManager.initVault(amount);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initProducts() {
        while (true) {
            System.out.println("상품명과 가격, 수량을 입력해 주세요.");
            try {
                String buffer = Console.readLine();
                parseProductsInput(buffer);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void parseProductsInput(String buffer) throws MyIllegalArgumentException {
        String[] productSpecs = buffer.split(";");

        for (String productSpec : productSpecs) {
            String[] token = productSpec
                    .replaceAll("\\[\\|\\]", "")
                    .split(",");

            for (String tmp : token) {
                System.out.println(tmp);
            }
        }
    }
}
