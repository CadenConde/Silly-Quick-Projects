import java.util.*;

public class Problem47 {

    public static void main(String[] args) {
        // 37960
        int findNum = 4;
        long n = 0;
        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        int f4 = 0;
        while (!((findNum == f1) && (findNum == f2) && (findNum == f3) && (findNum == f4))) {
            n++;
            f1 = primeFactors(n).size();
            f2 = primeFactors(n + 1).size();
            f3 = primeFactors(n + 2).size();
            f4 = primeFactors(n + 3).size();
        }
        System.out.println(n);
    }

    static boolean isPrime(long primeCand) {
        if (primeCand == 2 || primeCand == 3) {
            return true;
        } else if (primeCand % 2 == 0 || primeCand % 3 == 0) {
            return false;
        } else {
            for (long i = 1; (i * 6) - 1 <= Math.ceil(Math.sqrt(primeCand)); i++) {
                if (primeCand % ((i * 6) - 1) == 0 || primeCand % ((i * 6) + 1) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static ArrayList<Long> primeFactors(long FactorMe) {
        ArrayList<Long> returnFactors = new ArrayList<Long>();
        for (long i = 2; i <= Math.ceil(Math.sqrt(FactorMe)); i++) {
            if (FactorMe % i == 0) {
                if (isPrime(i)) {
                    returnFactors.add(i);
                }
                if (isPrime(FactorMe / i)) {
                    returnFactors.add(FactorMe / i);
                }
            }
        }
        return returnFactors;
    }
}
