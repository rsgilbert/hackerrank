package hackerrank.learning;

import java.util.BitSet;

public class MyBitSet {
    public static void main(String[] args) {
        BitSet b1 = new BitSet();
        b1.set(3);
        b1.set(4);
        b1.set(5, false);

        System.out.println(b1.cardinality());
        BitSet b2 = new BitSet();
        b2.set(3, 6);
        System.out.println(b2.toString());
        b2.xor(b1);


        System.out.println(b1.toString());
        System.out.println(b2.toString());

    }
}
