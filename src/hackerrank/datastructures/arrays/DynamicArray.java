package hackerrank.datastructures.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> returnList = new ArrayList<>();
//        List<List<Integer>> seqList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            seqList.add(new ArrayList<>());
//        }

        List<List<Integer>> seqList = Stream.<List<Integer>>generate(ArrayList::new)
                .limit(n)
                .collect(Collectors.toList());


        int lastAnswer = 0;

        for (List<Integer> query : queries) {
            int x = query.get(1);
            int y = query.get(2);
            int idx = (x ^ lastAnswer) % n;
            List<Integer> seq = seqList.get(idx);
            if (query.get(0) == 1) {
                seq.add(y);
            } else {
                int pos = y % seq.size();
                lastAnswer = seq.get(pos);
                System.out.println(lastAnswer);
            }
        }

        return returnList;
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int noOfSequences = sc.nextInt();
        int noOfQueries = Integer.parseInt(sc.nextLine().trim());

        IntStream.rangeClosed(1, noOfQueries)
                .forEach(i -> {

                });
    }
}
