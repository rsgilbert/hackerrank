package hackerrank.util;

import java.util.*;

class Item {
    private int size = 1;
    private Item root = null;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Item getRoot() {
        return root;
    }

    public void setRoot(Item root) {
        this.root = root;
    }
}

public class IntegerDisjointSet {
    private List<Item> itemList = new ArrayList<>();

    /**
     * Create a DisjointSet of @param{setsCount} sets initialized with one item each.
     */
    public IntegerDisjointSet(int setsCount) {
        for (int idx = 0; idx < setsCount; idx++) {
            itemList.add(new Item());
        }
    }

    public Item getRoot(Item item) {
        List<Item> oldItems = new ArrayList<>();
        while (item.getRoot() != null) {
            oldItems.add(item);
            item = item.getRoot();
        }
        // We improve performance by keeping track of changes in root for items
        for(Item oldItem: oldItems) {
            if (oldItem != item) {
                oldItem.setRoot(item);
            }
        }
        return item;
    }

    public void union(int position1, int position2) {
        Item item1Root = getRoot(itemList.get(position1));
        Item item2Root = getRoot(itemList.get(position2));
        // You must ensure the two roots are different
        if (item1Root != item2Root) {
            item2Root.setRoot(item1Root);
            item1Root.setSize(item1Root.getSize() + item2Root.getSize());
        }
    }

    public int getSize(int index) {
        return getRoot(itemList.get(index)).getSize();
    }

}
/*
 3 7
 Q 1
 M 1 2
 Q 2
 M 2 3
 Q 3
 Q 2
 Q 3
 */
