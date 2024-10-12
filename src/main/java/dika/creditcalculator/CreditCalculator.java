package dika.creditcalculator;

public class CreditCalculator {

    private String[] dataString;

    public CreditCalculator(String[] dataString) throws InvalidArgumentException {
        this.dataString = dataString;
    }

    public double crediCalc() throws InvalidArgumentException {
        double res;
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
        return res;
    }
}
