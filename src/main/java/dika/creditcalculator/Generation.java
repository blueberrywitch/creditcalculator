package dika.creditcalculator;

public abstract class Generation {
    private double loanAmount;
    private double monthlyPayment;
    private double percent;
    private double amountOfPay = 0;

    public void possibilityOfRepaying(double loanAmount, double monthlyPayment, double percent) throws InvalidArgumentException {
        if (!(loanAmount * percent * 0.01 < monthlyPayment * 12)) {
            throw new InvalidArgumentException("impossible to repay the loan");
        }
    }
}
