package core;

public class PrimeNumberChecker {
    public static boolean validate(int number) {
	for (int i = 2; i < (number); i++) {
	    if (number % i == 0) {
		return false;
	    }
	}
	return true;
    }

    public static String validate(int number, int j) {
	for (int i = 2; i < (number); i++) {
	    if (number % i == 0) {
		return "not a prime number";
	    }
	}
	return "prime number";

    }
}
