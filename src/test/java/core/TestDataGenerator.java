package core;

import java.text.DecimalFormat;

public class TestDataGenerator {

    int length = 0, result = 0;
    static int max = 100;
    static int tcNum = 100;
    static DecimalFormat formatter = new DecimalFormat("00");

    // String aFormatted = formatter.format(length);

    public static void main(String[] args) {

	for (int i = 2; i <= max; i++) {
	    int k = i - 1;
	    System.out.println("TC-01." + formatter.format(k) + " (" + i + " is " + PrimeNumberChecker.validate(i, 0)
		    + ")" + "," + i + "," + PrimeNumberChecker.validate(i));
	}
    }
}
