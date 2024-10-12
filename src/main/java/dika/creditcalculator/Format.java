package dika.creditcalculator;

import java.text.DecimalFormat;

public class Format {

    private double res;

    public Format(double res){
        this.res = res;
    }

    public void form(){
        DecimalFormat dF = new DecimalFormat("#.0");
        System.out.println(dF.format(res));
    }
}
