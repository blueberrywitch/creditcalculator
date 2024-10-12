package dika.creditcalculator.util;

import dika.creditcalculator.exception.InvalidArgumentException;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Scan {
    public String[] scanData() throws InvalidArgumentException {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(" ");
        try {
            for (int i = 0; i < data.length - 1; i++) {
                Double.parseDouble(data[i]);
            }
        } catch (NumberFormatException e) {
            log.info("Must be a double number!");
            throw new InvalidArgumentException("Must be a double number!");
        }

        for (int i = 0; i < data.length - 1; i++) {
            if (Double.parseDouble(data[i]) <= 0) {
                throw new InvalidArgumentException("Wrong number");
            }
        }

        return data;
    }
}
