package hackerrank.java.datastructures;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;


public class PairHashset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        class Pair {
            String item1, item2;

                public Pair(String item1, String item2) {
                    this.item1 = item1;
                    this.item2 = item2;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    Pair pair = (Pair) o;
                    return Objects.equals(item1, pair.item1) &&
                            Objects.equals(item2, pair.item2);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(item1, item2);
                }
            }


        HashSet<Pair> pairHashSet = new HashSet<>();
        for(int idx = 0; idx < t; idx++) {
            Pair p = new Pair(pair_left[idx], pair_right[idx]);
            pairHashSet.add(p);
            System.out.println(pairHashSet.size());
        }
    }
}
