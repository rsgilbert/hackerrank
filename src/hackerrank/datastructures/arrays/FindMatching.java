package hackerrank.datastructures.arrays;

public class FindMatching {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] matches = new int[queries.length];

        for(String s: strings) {
            for(int qIdx = 0; qIdx < queries.length; qIdx++) {
                if(s.contains(queries[qIdx])) {
                    matches[qIdx] += 1;
                }
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        String[] strings = new String[] { "Joyce", "abigail", "Mark", "Peter"};
        String[] queries = new String[] { "a", "b", "rk", "e"  };
        for(int c: matchingStrings(strings, queries)) System.out.println(c);
    }

}
