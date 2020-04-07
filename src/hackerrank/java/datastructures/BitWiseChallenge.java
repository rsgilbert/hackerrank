package hackerrank.java.datastructures;

import java.util.*;

public class BitWiseChallenge {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int bitSetLength = sc.nextInt();
        int numberOfOps = sc.nextInt();
        sc.nextLine();

        BitSet bitSet1 = new BitSet(bitSetLength);
        BitSet bitSet2 = new BitSet(bitSetLength);

        for(int i = 0; i < numberOfOps; i ++ ) {
            String GATE = sc.next();
            int bitSetChosen = sc.nextInt();
            int bitSetIdx = Integer.parseInt(sc.nextLine().trim());

            BitSet bitSet;
            BitSet otherBitSet;

            if (bitSetChosen == 1) {
                bitSet = bitSet1;
                otherBitSet = bitSet2;
            } else {
                bitSet = bitSet2;
                otherBitSet = bitSet1;
            }


            switch (GATE) {
                case "AND": {
                    bitSet.and(otherBitSet);
                    break;

                }
                case "OR": {
                    bitSet.or(otherBitSet);
                    break;
                }
                case "XOR": {
                    bitSet.xor(otherBitSet);
                    break;
                }
                case "FLIP": {
                    bitSet.flip(bitSetIdx);
                    break;
                }
                case "SET": {
                    bitSet.set(bitSetIdx);
                    break;
                }
            }

            System.out.printf("%d %d\n", bitSet1.cardinality(), bitSet2.cardinality());

        }
    }
}
