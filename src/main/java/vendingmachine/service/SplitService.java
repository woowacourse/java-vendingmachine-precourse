package vendingmachine.service;

import java.util.List;

import vendingmachine.domain.ProductCandidate;

public interface SplitService {
	List<ProductCandidate> splitProducts(String input);
}
