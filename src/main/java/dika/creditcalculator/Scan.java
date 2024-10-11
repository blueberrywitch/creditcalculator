package dika.creditcalculator;

import java.util.Scanner;

public class Scan {
    public String[] scanData() throws InvalidArgumentException {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(" ");
        try {
            for (int i = 0; i < 2; i++) {
                Double.parseDouble(data[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            if (Double.parseDouble(data[i]) <= 0) {
                throw new InvalidArgumentException("wrong number");
            }
        }

        return data;
    }
}
