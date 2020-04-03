import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // US
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String usCurrency = nf.format(payment);

        // India
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("Rs.");
        dfs.setGroupingSeparator(',');
        ((DecimalFormat) nf).setDecimalFormatSymbols(dfs);
        String indiaCurrency = nf.format(payment);

        // China
        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String chinaCurrency = nf.format(payment);

        // France
        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String franceCurrency = nf.format(payment);

        System.out.println("US: " + usCurrency);
        System.out.println("India: " + indiaCurrency);
        System.out.println("China: " + chinaCurrency);
        System.out.println("France: " + franceCurrency);
    }
}
