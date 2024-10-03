public class Problem52 {
    public static void main(String[] args) {
        algs algs = new algs();
        long base = 1_000_000;
        long n = 100_000;
        while (true) {
            if (algs.fingerprint(n) == algs.fingerprint(2 * n)) {
                if (algs.fingerprint(n) == algs.fingerprint(3 * n)) {
                    if (algs.fingerprint(n) == algs.fingerprint(4 * n)) {
                        if (algs.fingerprint(n) == algs.fingerprint(5 * n)) {
                            if (algs.fingerprint(n) == algs.fingerprint(6 * n)) {
                                System.out.println(n);
                                break;
                            }
                        }
                    }
                }
            }
            n++;
            if (6 * n >= base) {
                n = base;
                base *= 10;
            }
        }
    }
}
