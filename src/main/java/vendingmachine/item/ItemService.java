package vendingmachine.item;

import vendingmachine.item.dto.ItemDto;
import vendingmachine.utils.message.ItemErrorMessage;
import java.util.List;

public class ItemService {

    public static final int ITEM_PRICE_MIN = 100;
    public static final int ITEM_PRICE_DIV = 10;

    private final ItemRepository itemRepository;
    private final ItemKeyRepository itemKeyRepository;

    private ItemService() {
        itemRepository = ItemRepository.getInstance();
        itemKeyRepository= ItemKeyRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final ItemService instance = new ItemService();
    }

    public static ItemService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void addItem(ItemDto itemDto) {
        Integer price = itemDto.getPrice();
        if(price < ITEM_PRICE_MIN) {
            throw new IllegalArgumentException(ItemErrorMessage.PRICE_RANGE
                    .replaceFirst("min", String.valueOf(ITEM_PRICE_MIN)));
        }
        if((price % ITEM_PRICE_DIV) != 0) {
            throw new IllegalArgumentException(ItemErrorMessage.PRICE_DIV
                    .replaceFirst("div", String.valueOf(ITEM_PRICE_DIV)));
        }
        itemKeyRepository.save(ItemKey.fromName(itemDto.getName()));
        Integer key = getItemIdByName(itemDto.getName());

        Item newItem = Item.fromItemDto(itemDto);
        newItem.setId(key);
        itemRepository.save(newItem);
    }

    public void purchaseItem(String itemName, int quantity) {
        reduceStock(itemName, quantity);
    }

    public void cancelPurchase(String itemName, int quantity) {
        addStock(itemName, quantity);
    }

    private void addStock(String itemName, int quantity) {
        Item item = getItemByName(itemName);
        item.addStock(quantity);
    }

    private void reduceStock(String itemName, int quantity) {
        Item item = getItemByName(itemName);
        item.reduceStock(quantity);
    }

    public void hasStockQuantity(String itemName, int quantity) {
        Item item = getItemByName(itemName);
        item.hasStockQuantity(quantity);
    }

    public Integer getPriceByName(String itemName) {
        Item item = getItemByName(itemName);
        return item.getPrice();
    }

    private Item getItemByName(String name) {
        Integer itemId = getItemIdByName(name);
        return itemRepository.findOneById(itemId);
    }

    private Integer getItemIdByName(String name) {
        return itemKeyRepository.findOneByName(name).getId();
    }

    public boolean isNotStockAllItem() {
        List<ItemKey> AllItemKey = itemKeyRepository.findAll();
        for(ItemKey key : AllItemKey) {
            Item item = itemRepository.findOneById(key.getId());
            if(!item.isNotStock()){
                return false;
            }
        }
        return true;
    }

    public Integer getLowestPrice(){
        List<ItemKey> AllItemKey = itemKeyRepository.findAll();

        Integer lowestPrice = null;
        for(ItemKey key : AllItemKey) {
            Item item = itemRepository.findOneById(key.getId());
            if(item.isNotStock()) {
                continue;
            }

            int itemPrice = item.getPrice();
            if(lowestPrice == null) {
                lowestPrice = itemPrice;
            }
            else if(lowestPrice > itemPrice) {
                lowestPrice = itemPrice;
            }
        }
        return lowestPrice;
    }
}