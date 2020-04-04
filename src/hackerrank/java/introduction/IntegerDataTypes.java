package hackerrank.java.introduction;

import java.util.Scanner;

public class IntegerDataTypes {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                double minByteAbs =  Math.pow(2, 7);
                double minShortAbs = Math.pow(2, 15);
                double minIntAbs = Math.pow(2, 31);

                System.out.println(x + " can be fitted in:");
                if (x >= -minByteAbs && x <= minByteAbs - 1) System.out.println("* byte");
                if (x >= -minShortAbs && x <= minShortAbs - 1) System.out.println("* short");
                if (x >= -minIntAbs && x <= minIntAbs - 1) System.out.println("* int");
                System.out.println("* long");


                //Complete the code
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}



