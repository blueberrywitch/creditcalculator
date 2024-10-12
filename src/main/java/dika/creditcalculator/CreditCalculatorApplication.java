package dika.creditcalculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditCalculatorApplication {

    public static void main(String[] args) throws Exception {
        Scan scan = new Scan();
        String[] dataString = scan.scanData();

        CreditCalculator creditCalculator = new CreditCalculator(dataString);

        Format format = new Format();
        format.form(creditCalculator.creditCalc());
    }
}
