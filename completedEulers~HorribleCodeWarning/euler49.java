import java.util.*;

public class euler49 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int count = 0;
        int save = 0;
        int save2 = 0;

        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        long[] prints = new long[primes.size()];

        for (int i = 0; i < primes.size(); i++) {
            prints[i] = fingerprint(primes.get(i));
        }

        for (int i = 0; i < prints.length; i++) {
            count = 0;
            for (int j = i + 1; j < prints.length; j++) {
                if (prints[j] == prints[i]) {
                    count++;
                    if (count == 1) {
                        save = primes.get(j);
                    } else if (count == 2) {
                        save2 = primes.get(j);
                    } else if (count >= 3) {
                        if ((primes.get(i) - save == save - save2) || (primes.get(i) - save2 == save2 - primes.get(j))
                                || (primes.get(i) - save == save - primes.get(j))
                                || save - save2 == save2 - primes.get(j)) {
                            System.out.println(primes.get(i) + " " + save + " " + save2 + " " + primes.get(j));
                        }
                    }
                }
            }
        }
    }

    static long fingerprint(long input) {
        long out = 0;
        while (input > 0) {
            switch ((int) input % 10) {
                case 0:
                    out += 1;
                    break;
                case 1:
                    out += 10;
                    break;
                case 2:
                    out += 100;
                    break;
                case 3:
                    out += 1000;
                    break;
                case 4:
                    out += 10000;
                    break;
                case 5:
                    out += 100000;
                    break;
                case 6:
                    out += 1000000;
                    break;
                case 7:
                    out += 10000000;
                    break;
                case 8:
                    out += 100000000;
                    break;
                case 9:
                    out += 1000000000;
                    break;

            }
            input /= 10;
        }
        return out;
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
