package dika.creditcalculator;

public class Business extends Generation {
    private double loanAmount;
    private final double monthlyPayment;
    private final double percent;

    public Business(double loanAmount, double monthlyPayment, double percent) {
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.percent = percent;
    }

    public double amountOfPay() {
        double amountOfPay = 0;
        if (loanAmount - monthlyPayment * 12 <= 0) {
            amountOfPay = loanAmount;
        } else {
            amountOfPay = monthlyPayment * 12;
            loanAmount -= monthlyPayment * 12;
            while (loanAmount > 0) {
                loanAmount = loanAmount * (percent * 0.01 + 1);
                if (loanAmount > monthlyPayment * 12) {
                    loanAmount -= monthlyPayment * 12;
                    amountOfPay += monthlyPayment * 12;
                } else {
                    amountOfPay += loanAmount;
                    loanAmount = 0;
                }
            }
        }
        return amountOfPay;
    }
}
