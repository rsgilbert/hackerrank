package hackerrank.util;

import java.util.*;

public class DisjointSet <T> {
    private Map<T, Integer> pointersMap = new HashMap<>();
    private List<Set<T>> disjointSetsList = new ArrayList<>();

    public DisjointSet() {
        disjointSetsList = new ArrayList<>();
    }

    /**
     * Create a DisjointSet of @param{setsCount} sets each initialized with one item.
     * @param setsCount
     */
    public DisjointSet(int setsCount) {
        for(Integer idx = 0; idx < setsCount; idx++) {
            T item = (T) idx;
            disjointSetsList.add(createItemSet(item));
            pointersMap.put(item, idx);
        }
    }

    public void makeSet(T item) {
        disjointSetsList.add(createItemSet(item));
        int position = disjointSetsList.size() - 1;
        pointersMap.put(item, position);
    }

    private Set<T> createItemSet(T item) {
        Set<T> set = new HashSet<>();
        set.add(item);
        return set;
    }

    public int find(T item) {
        return pointersMap.get(item);
    }

    public Set<T> getSet(int pointer) {
        return disjointSetsList.get(pointer);
    }

    public void union(T item1, T item2) {
        int item1Pointer = find(item1);
        int item2Pointer = find(item2);

        Set<T> set1 = getSet(item1Pointer);
        Set<T> set2 = getSet(item2Pointer);

        set1.addAll(set2);
        set2.clear();
        pointersMap.put(item2, item1Pointer);
    }
}
