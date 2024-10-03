import java.math.BigInteger;

public class Problem57 {
    public static void main(String[] args) {
        int ans = 0;
        BigInteger two = BigInteger.valueOf(2);

        BigInteger pell = BigInteger.valueOf(2);
        BigInteger lastPell = BigInteger.valueOf(1);
        BigInteger coPell = BigInteger.valueOf(6);
        BigInteger lastCoPell = BigInteger.valueOf(2);
        BigInteger temp = BigInteger.ZERO;

        for (int i = 2; i < 1000; i++) {
            temp = pell;
            pell = pell.multiply(two).add(lastPell);
            lastPell = temp;

            temp = coPell;
            coPell = coPell.multiply(two).add(lastCoPell);
            lastCoPell = temp;

            if (getDigitCount(pell) < getDigitCount(coPell.divide(two))) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static int getDigitCount(BigInteger number) {
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * number.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
            return digitCount - 1;
        }
        return digitCount;
    }
}
