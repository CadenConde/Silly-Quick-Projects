public class Problem58 {
    public static void main(String[] args) {
        algs algs = new algs();
        double count = 1;
        long primes = 0;
        int tal = 1;
        int layer = 1;
        do {
            tal += 8 * layer;
            if (algs.isPrime(tal)) {
                primes++;
            }
            if (algs.isPrime(tal - (2 * layer))) {
                primes++;
            }
            if (algs.isPrime(tal - (4 * layer))) {
                primes++;
            }
            if (algs.isPrime(tal - (6 * layer))) {
                primes++;
            }
            count += 4;
            layer++;
        } while (primes / count > .1);
        System.out.println(primes / count);
        System.out.println(2 * (layer - 1) + 1);
    }
}