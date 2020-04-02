import java.util.Scanner;

public class Stdin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int intValue = scan.nextInt();
        String doubleValueAsString = scan.next();
        double doubleValue = Double.parseDouble(doubleValueAsString);
        scan.nextLine();
        String stringValue = scan.nextLine();

        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + intValue);
    }


}
