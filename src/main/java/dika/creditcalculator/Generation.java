package dika.creditcalculator;

public abstract class Generation {

    public void possibilityOfRepaying(double loanAmount, double monthlyPayment, double percent) throws InvalidArgumentException {
        if (!(loanAmount * percent * 0.01 < monthlyPayment * 12)) {
            throw new InvalidArgumentException("impossible to repay the loan");
        }
    }
}
