public class euler77 {
    static int SUM = 71;
    final static int COINS = 98;

    static long nway[][] = new long[SUM + 1][COINS + 1];

    static int coins[] = new int[99];

    public static void initialise() {
        for (int i = 0; i <= SUM; i++)
            for (int j = 0; j <= COINS; j++)
                nway[i][j] = -1;

        nway[0][0] = 1;
    }

    public static long f(int s, int j) {
        if (j < 0 || s < 0)
            return 0;

        if (nway[s][j] > -1)
            return nway[s][j];

        // System.out.println (s + "\t" + (s-coins[j]) + "\t" + j);
        return (f(s, j - 1) + f(s - coins[j], j));
    }

    public static void main(String[] args) {
        int n = 2;
        for (int i = 1; i < 100; n++) {
            if (isPrime(n)) {
                coins[i - 1] = n;
                i++;
            }
        }
        initialise();
        System.out.println(SUM + " " + f(SUM, COINS));
        // System.out.println(coins[98]);
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