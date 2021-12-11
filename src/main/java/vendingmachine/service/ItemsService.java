package vendingmachine.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.ItemName;
import vendingmachine.domain.item.ItemPrice;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.dto.ItemDto;
import vendingmachine.dto.ItemNameDto;
import vendingmachine.exception.NotEnoughBalanceException;
import vendingmachine.repository.ItemsRepository;
import vendingmachine.repository.UserBalanceRepository;

public class ItemsService {
	private static final ItemsService itemsService = new ItemsService();
	private final ItemsRepository itemsRepository = ItemsRepository.getInstance();
	private final UserBalanceRepository userBalanceRepository = UserBalanceRepository.getInstance();

	private ItemsService() {
	}

	public static ItemsService getInstance() {
		return itemsService;
	}

	public void createItem(ItemDto itemDto) {
		Item item = itemDto.toEntity();
		itemsRepository.create(item);
	}

	public void buyItem(ItemNameDto itemNameDto) {
		ItemName itemName = itemNameDto.toEntity();
		Item item = itemsRepository.findByItemName(itemName);

		UserBalance userBalance = userBalanceRepository.get();
		if (userBalance.toInt() < item.getItemPrice().toInt()) {
			throw new NotEnoughBalanceException();
		}

		Item purchasedItem = item.buy();

		userBalanceRepository.update(userBalance.subtract(item.getItemPrice()));
		itemsRepository.updateByItemName(itemName, purchasedItem);
	}

	public boolean checkAllItemsSoldOut() {
		List<Item> items = itemsRepository.findAll();
		return items.stream().allMatch(Item::isSoldOut);
	}

	public ItemPrice getMinItemPrice() {
		List<Item> items = itemsRepository.findAll();
		List<ItemPrice> itemPrices = items.stream()
			.map(Item::getItemPrice)
			.collect(Collectors.toList());

		return Collections.min(itemPrices);
	}
}
