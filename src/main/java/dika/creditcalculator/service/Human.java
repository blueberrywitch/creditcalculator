package dika.creditcalculator.service;

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

    public double amountOfPay() {
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
        return amountOfPay;
    }
}
