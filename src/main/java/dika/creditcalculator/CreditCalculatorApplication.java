package dika.creditcalculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;

@SpringBootApplication
@Slf4j
public class CreditCalculatorApplication {

    public static void main(String[] args) throws Exception {
        Scan scan = new Scan();
        double res;
        String[] dataString = scan.scanData();
        if (dataString[3].equals("human")) {
            try (Human human = new Human(Double.parseDouble(dataString[0]), Double.parseDouble(dataString[1]), Double.parseDouble(dataString[2]))) {
                human.possibilityOfRepaying(Double.parseDouble(dataString[0]), Double.parseDouble(dataString[1]), Double.parseDouble(dataString[2]));
                res = (human.amountOfPay() - Double.parseDouble(dataString[0]));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try (Business business = new Business(Double.parseDouble(dataString[0]), Double.parseDouble(dataString[1]), Double.parseDouble(dataString[2]))) {
                business.possibilityOfRepaying(Double.parseDouble(dataString[0]) -  Double.parseDouble(dataString[1])*12, Double.parseDouble(dataString[1]), Double.parseDouble(dataString[2]));
                res = (business.amountOfPay() - Double.parseDouble(dataString[0]));
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
        DecimalFormat dF = new DecimalFormat( "#.0" );
        System.out.println(dF.format(res));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
