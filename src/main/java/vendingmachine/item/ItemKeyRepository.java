package vendingmachine.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 이 클래스는 ItemRepository 의 items Key 값을 관리하는 repository 입니다.
 * ItemKey 의 id 가 ItemRepository 의 items key 값 입니다.
 *
 * itemKeys 의 Key 값은 Item 의 name 으로 설정했으며,
 * Item 의 name 이 변경될 경우 기존 id 를 갖는 새로운 Key 를 생성하고,
 * 기존 Key 는 삭제합니다.
 */
public class ItemKeyRepository {

    private final Map<String, ItemKey> itemKeys = new ConcurrentHashMap<>();

    private static class InnerInstanceClazz {
        private static final ItemKeyRepository instance = new ItemKeyRepository();
    }

    public static ItemKeyRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void save(ItemKey itemKey) {
        if(itemKey.isNullId()) {
            itemKey.setId(itemKeys.size());
        }
        itemKeys.put(itemKey.getName(), itemKey);
    }

    public List<ItemKey> findAll() {
        return new ArrayList<>(itemKeys.values());
    }

    public ItemKey findOneByName(String name) {
        return itemKeys.get(name);
    }
}