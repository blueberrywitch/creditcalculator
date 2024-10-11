package dika.creditcalculator;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Human extends Generation {
    private double loanAmount;
    private final double monthlyPayment;
    private final double percent;
    private double amountOfPay = 0;

    public Human(double loanAmount, double monthlyPayment, double percent) {
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.percent = percent;
    }

    public double amountOfPay(){
        log.info("d");
        log.info("loan {}", loanAmount);
        while (loanAmount > 0) {
            loanAmount = loanAmount + loanAmount * (percent * 0.01);
            if (loanAmount > monthlyPayment * 12) {
                loanAmount -= monthlyPayment * 12;
                amountOfPay += monthlyPayment * 12;
            } else {
                amountOfPay += loanAmount;
                loanAmount = 0;
            }
        }
        return amountOfPay ;
    }

    @Override
    public void close() throws Exception {

    }
}
