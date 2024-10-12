package dika.creditcalculator.service;

import dika.creditcalculator.exception.InvalidArgumentException;
import dika.creditcalculator.enums.Business;
import dika.creditcalculator.enums.Person;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreditCalculator {

    private final String[] dataString;

    public double creditCalc() throws InvalidArgumentException {
        double res;
        double loanAmount = Double.parseDouble(dataString[0]);
        final double monthlyPayment = Double.parseDouble(dataString[1]);
        final double percent = Double.parseDouble(dataString[2]);
        final String clientType = dataString[3];
        if (clientType.equalsIgnoreCase(Person.HUMAN.toString())) {
            Human human = new Human(loanAmount, monthlyPayment, percent);
            human.possibilityOfRepaying(loanAmount, monthlyPayment, percent);
            res = (human.amountOfPay() - loanAmount);

        } else {
            Business business = new Business(loanAmount, monthlyPayment, percent);
            business.possibilityOfRepaying(loanAmount - monthlyPayment * 12, monthlyPayment, percent);
            res = (business.amountOfPay() - loanAmount);
        }

        return res;
    }
}
