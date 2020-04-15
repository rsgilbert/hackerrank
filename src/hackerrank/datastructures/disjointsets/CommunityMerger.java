package hackerrank.datastructures.disjointsets;

import hackerrank.util.*;

import java.util.Scanner;

public class CommunityMerger {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfPeople = scanner.nextInt();
        int numberOfQueries = Integer.parseInt(scanner.nextLine().trim());

        IntegerDisjointSet communities = new IntegerDisjointSet(numberOfPeople);

        for(int i = 0; i < numberOfQueries; i++) {
            String[] query = scanner.nextLine().trim().split("\\s");
            if(query[0].equals("Q")) {
                // Query
                // We subtract 1 so as to go back to 0-based-indexing
                int item = Integer.parseInt(query[1]) - 1;
                int communitySize = communities.getSize(item);
                System.out.println(communitySize);
            } else {
                // Merge
                int item1 = Integer.parseInt(query[1]) - 1;
                int item2 = Integer.parseInt(query[2]) - 1;
                communities.union(item1, item2);
            }
        }
    }
}
/**
 20 6
 M 6 7
 M 17 18
 M 18 19
 M 6 19
 Q 17
 Q 9

 */