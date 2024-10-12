package dika.creditcalculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;

@SpringBootApplication
@Slf4j
public class CreditCalculatorApplication {

    public static void main(String[] args) throws Exception {
        Scan scan = new Scan();
        String[] dataString = scan.scanData();

        CreditCalculator creditCalculator = new CreditCalculator(dataString);

        Format format = new Format(creditCalculator.crediCalc());
        format.form();
    }
}
