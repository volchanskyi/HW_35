package core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrimeNumberCheckerTest implements ITest {
    // String csvFile = "./primes.csv";
    String csvFile = System.getProperty("testcases"); // mvn site
    // -Dtestcases="./input.csv"
    private String test_name = "";

    public String getTestName() {
	return test_name;
    }

    private void setTestName(String a) {
	test_name = a;
    }

    @BeforeMethod(alwaysRun = true)
    public void beforemethod(Method method, Object[] parameters) {
	setTestName(method.getName());
	Override a = method.getAnnotation(Override.class);
	String testCaseId = (String) parameters[a.id()];
	setTestName(testCaseId);
    }

    @DataProvider(name = "prime number")
    public Iterator<String[]> data() throws IOException {
	String cvsLine = "";
	String[] a = null;
	ArrayList<String[]> al = new ArrayList<>();
	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	while ((cvsLine = br.readLine()) != null) {
	    a = cvsLine.split(",");
	    al.add(a);
	}
	br.close();
	return al.iterator();
    }

    @Override // @Override(id = 0)
    @Test(timeOut = 1000, dataProvider = "prime number")
    public void test(String a, String b, String c) {
	assertThat(PrimeNumberChecker.validate(Integer.parseInt(b)), equalTo(Boolean.parseBoolean(c)));
    }
}
