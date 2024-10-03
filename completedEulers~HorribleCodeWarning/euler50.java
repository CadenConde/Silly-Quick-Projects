import java.util.*;

public class euler50 {
    public static void main(String[] args) {
        int sum = 0;
        int sumlength = 0;
        int ans = 0;
        int ansLength = 0;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= 600_000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int s = 0; s < primes.size(); s++) {
            sum = 0;
            sumlength = 1;
            for (int j = s + 1; (j < primes.size()) && (sum < 1_000_000); j++) {
                sum += primes.get(j);
                sumlength++;
                if (isPrime(sum) && sumlength > ansLength) {
                    ans = sum;
                    ansLength = sumlength;
                }
            }
        }
        System.out.println(primes.size());
        System.out.println(ans + " " + ansLength);
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
}