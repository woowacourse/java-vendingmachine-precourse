package vendingmachine.item;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 이 클래스는 Item 객체를 관리하는 repository 입니다.
 * items 의 Key 값은 ItemKeyRepository 에서 할당 받습니다.
 * Item 객체의 데이터가 변경될 수 있으니 Key 값으로 사용하지 않습니다.
 */
public class ItemRepository {

    private final Map<Integer, Item> items = new ConcurrentHashMap<>();

    private static class InnerInstanceClazz {
        private static final ItemRepository instance = new ItemRepository();
    }

    public static ItemRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void save(Item item) {
        items.put(item.getId(), item);
    }

    public Item findOneById(Integer id) {
        return items.get(id);
    }
}