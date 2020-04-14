package hackerrank.learning;

import hackerrank.util.DisjointSet;

import java.util.Set;

public class UseDisjointSet {
    public static void main(String[] args) {
        // Create disjoint set
        int numberOfItems = 3;
        DisjointSet<Integer> disjointSet = new DisjointSet<>(3);
        int item1Pointer = disjointSet.find(2);
        System.out.println(item1Pointer);
        disjointSet.union(1, 2);
        Set<Integer> set = disjointSet.getSet(1);
        System.out.println(set);



    }
}
