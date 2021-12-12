package vendingmachine.item;

import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.dto.ItemDto;
import vendingmachine.utils.ItemErrorMessage;

public class ItemService {

    public static final int ITEM_PRICE_MIN = 100;
    public static final int ITEM_PRICE_DIV = 10;

    private final ItemRepository itemRepository;

    private ItemService() {
        itemRepository = ItemRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final ItemService instance = new ItemService();
    }

    public static ItemService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void addItem(ItemDto itemDto) {
        int price = itemDto.getPrice();
        if(price < ITEM_PRICE_MIN) {
            throw new IllegalArgumentException(ItemErrorMessage.PRICE_RANGE
                    .replaceFirst("min", String.valueOf(ITEM_PRICE_MIN)));
        }
        if((price % ITEM_PRICE_DIV) != 0) {
            throw new IllegalArgumentException(ItemErrorMessage.PRICE_DIV
                    .replaceFirst("div", String.valueOf(ITEM_PRICE_DIV)));
        }
        itemRepository.save(Item.fromItemDto(itemDto));
    }

    public void orderItem(String name) {
        try{
            Item item = itemRepository.findOneByName(name);
            item.reduceStock();
        }catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }catch(NotEnoughStockException e) {
            throw new NotEnoughStockException(e.getMessage());
        }
    }
}