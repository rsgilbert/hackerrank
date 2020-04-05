package hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    static String regex = "<(.+)>([^<]+)</\\1>";
    static Pattern p = Pattern.compile(regex);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);

            if (m.find()) {
                System.out.println(m.group(2));
                while (m.find()) {
                    System.out.println(m.group(2));
                }
            } else System.out.println("None");
            testCases--;
        }
    }
}