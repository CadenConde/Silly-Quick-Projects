public class Problem3 {
    public static void main(String[] args) {
        System.out.println(greatestPrimeFactor(600851475143L));
    }

    static long greatestPrimeFactor(long FactorMe) {
        long returnFactor = 1;
        for (long i = 2; i <= Math.ceil(Math.sqrt(FactorMe)); i++) {
            if (FactorMe % i == 0) {
                if (isPrime(i) && i > returnFactor) {
                    returnFactor = i;
                }
                if (isPrime(FactorMe / i) && (FactorMe / i) > returnFactor) {
                    returnFactor = FactorMe / i;
                    return returnFactor;
                }
            }
        }
        return returnFactor;
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