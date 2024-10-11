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
        double res;
        String[] dataString = scan.scanData();
        double loanAmount = Double.parseDouble(dataString[0]);
        final double monthlyPayment = Double.parseDouble(dataString[1]);
        final double percent = Double.parseDouble(dataString[2]);
        if (dataString[3].equals(Person.HUMAN.toString())) {
            Human human = new Human(loanAmount, monthlyPayment, percent);
            human.possibilityOfRepaying(loanAmount, monthlyPayment, percent);
            res = (human.amountOfPay() - loanAmount);

        } else {
            Business business = new Business(loanAmount, monthlyPayment, percent);
            business.possibilityOfRepaying(loanAmount - monthlyPayment * 12, monthlyPayment, percent);
            res = (business.amountOfPay() - loanAmount);

        }
        DecimalFormat dF = new DecimalFormat("#.0");
        System.out.println(dF.format(res));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
