import java.util.ArrayList;

public class Problem49 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int n = 1000;

        int diff;
        while (n < 10000) {
            if (isPrime(n)) {
                primes.add(n);
            }
            n++;
        }

        long[] prints = new long[primes.size()];
        for (int i = 0; i < prints.length; i++) {
            prints[i] = fingerprint(primes.get(i));
        }

        for (int j = 0; j < prints.length; j++) {

            diff = 0;
            for (int k = j + 1; k < prints.length; k++) {
                if (prints[j] == prints[k]) {

                    // System.out.println(primes.get(j) + " " + primes.get(k));
                    if (primes.get(k) - primes.get(j) == diff) {
                        System.out.println(primes.get(j) + " *** " + primes.get(k));
                    }
                    diff = primes.get(k) - primes.get(j);
                }
            }
        }
    }

    static long fingerprint(int n) {
        long output = 0;
        while (n > 0) {
            switch (n % 10) {
                case 0:
                    output += 1;
                    break;
                case 1:
                    output += 10;
                    break;
                case 2:
                    output += 100;
                    break;
                case 3:
                    output += 1000;
                    break;
                case 4:
                    output += 10000;
                    break;
                case 5:
                    output += 100000;
                    break;
                case 6:
                    output += 1000000;
                    break;
                case 7:
                    output += 10000000;
                    break;
                case 8:
                    output += 100000000;
                    break;
                case 9:
                    output += 1000000000;
                    break;
            }
            n /= 10;
        }
        return output;
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
