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
        System.out.println("자판기가 보유한 동전");
        System.out.println(this.cashManager.getVaultStatus());
        initProducts();

        while (true) {
            try {
                System.out.println("투입 급액을 입력해 주세요.");
                String buffer = Console.readLine();
                Validator.validateCashInput(buffer);
                this.cashManager.setRemainCash(Integer.parseInt(buffer));

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println();
                System.out.println(String.format("투입 금액: %d", this.cashManager.getRemainCash()));

                if (!this.productManager.isProductAvailable() || this.cashManager.getRemainCash() < this.productManager.getMinPrice()) {
                    break;
                }

                System.out.println("구매할 상품명을 입력해 주세요.");
                String buffer = Console.readLine();
                Validator.validateProductName(buffer);

                if (!this.productManager.isProductExist(buffer)) {
                    throw new MyIllegalArgumentException(
                            String.format("Product [%s] doesn't exist", buffer)
                    );
                }

                this.cashManager.withdraw(this.productManager.getProductPrice(buffer));

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("잔돈");
        CashManager change = this.cashManager.getChanges();
        System.out.println(change.getVaultStatus());
    }

    private void initVault() {
        while (true) {
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            try {
                String buffer = Console.readLine();
                Validator.validateCashInput(buffer);
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
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void parseProductsInput(String buffer) throws MyIllegalArgumentException {
        String[] productSpecs = buffer.split(";");

        Validator.validateProductTypes(productSpecs.length);

        for (String productSpec : productSpecs) {
            String[] tokens = productSpec
                    .replaceAll("[\\[\\]]", "")
                    .split(",");

            Validator.validateProductInput(tokens);

            this.productManager.addProduct(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        }
    }
}
