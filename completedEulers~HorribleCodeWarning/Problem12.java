import java.lang.Math;
import java.util.ArrayList;

//problem 12
public class Problem12 {
    static ArrayList<Long> factorCheck(int num) {
        ArrayList<Long> factors = new ArrayList<Long>();
        for (long i = 1; i <= Math.round(Math.ceil((Math.sqrt(num)))); i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        int x = 1;
        int adder = 1;
        while (true) {
            if (factorCheck(x).size() > 500) {
                System.out.println(factorCheck(x));
                System.out.println(x);
                break;
            } else {
                adder++;
                x = x + adder;
            }
        }
    }
}
