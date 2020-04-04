package hackerrank.java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressRegex {
    public static void main(String[] args) {
        boolean isMatch1 = "192.192.192.1".matches(new MyRegex().pattern);
        boolean isMatch2 = "92.192.255.0".matches(new MyRegex().pattern);
        boolean isMatch3 = "242.".matches(new MyRegex().pattern);
        boolean isMatch4 = "255.242".matches(new MyRegex().pattern);

        // false
        boolean isMatch5 = "255.255.255.".matches(new MyRegex().pattern);



        System.out.println(isMatch1);
        System.out.println(isMatch2);
        System.out.println(isMatch3);
        System.out.println(isMatch4);
        System.out.println(isMatch5);
    }
}

class MyRegex {
    String pattern = "(((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.){3}((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))";
}