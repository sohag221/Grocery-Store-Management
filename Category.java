import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Category {
    private String name;
    private List<Item> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    //add item
    public void addItem(Item item) {
        items.add(item);
    }

    // remove item
    public void removeItem(String itemName) {
        Iterator <Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                break;
            }
        }
    }

    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}
