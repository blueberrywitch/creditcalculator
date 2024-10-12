package dika.creditcalculator.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Format {

    public void form(double res) {
        DecimalFormat dF = new DecimalFormat("#.0", DecimalFormatSymbols.getInstance(Locale.US));
        System.out.println(dF.format(res));
    }
}
