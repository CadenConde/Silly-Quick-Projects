import java.math.BigInteger;

public class Problem55 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 10; i < 10000; i++) {
            if (isLych(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean isLych(int input) {
        BigInteger lychTest = BigInteger.valueOf(input);
        for (int i = 1; i < 50; i++) {
            lychTest = lychTest.add(revInt(lychTest));
            if (lychTest.equals(revInt(lychTest))) {
                return false;
            }
        }
        return true;
    }

    static BigInteger revInt(BigInteger revMe) {
        BigInteger rev = BigInteger.valueOf(0);
        while (revMe.compareTo(BigInteger.ZERO) > 0) {
            rev = rev.multiply(BigInteger.TEN);
            rev = rev.add(revMe.mod(BigInteger.TEN));
            revMe = revMe.divide(BigInteger.TEN);
        }
        return rev;
    }

}
