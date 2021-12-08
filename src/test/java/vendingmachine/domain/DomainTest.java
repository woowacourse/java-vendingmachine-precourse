package vendingmachine.domain;

import org.junit.jupiter.api.BeforeEach;

public abstract class DomainTest {

    protected VendingMachine vendingMachine;

    @BeforeEach
    void setUp(){
        vendingMachine = new VendingMachine();
    }
}
