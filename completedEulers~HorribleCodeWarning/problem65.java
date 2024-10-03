import java.math.BigInteger;

public class problem65 {
    public static void main(String[] args) {
        int[] nums = new int[104];
        int start = 100 - 2;
        int counter = 1;
        BigInteger num = BigInteger.ONE;
        BigInteger den = BigInteger.ONE;
        BigInteger temp = BigInteger.ZERO;
        for (int i = 0; i < 104; i++) {
            if (i % 3 == 1) {
                nums[i] = 2 * counter;
                counter++;
            } else {
                nums[i] = 1;
            }
        }
        // System.out.println(Arrays.toString(nums));

        den = BigInteger.valueOf(nums[start]);
        num = den.multiply(BigInteger.valueOf(nums[start]));
        // System.out.println(nums[start]);
        // System.out.println(num);
        // System.out.println(den + "\n");
        // System.out.println(num);
        // System.out.println(den + "\n");

        for (int i = start - 1; i >= 0; i--) {
            temp = den;
            den = num;
            num = temp.add(den.multiply(BigInteger.valueOf(nums[i])));
            // System.out.println(nums[i]);
            // System.out.println(num);
            // System.out.println(den + "\n");
        }
        temp = den;
        den = num;
        num = temp.add(den.multiply(BigInteger.valueOf(2)));
        System.out.println(sumOfDigits(num));
        System.out.println(num.toString());
        System.out.println(den.toString());
    }

    public static BigInteger sumOfDigits(BigInteger bint) {
        BigInteger sum = BigInteger.ZERO;

        BigInteger currDigit = null;
        do {
            BigInteger divisor = findNearestPowerOfTen(bint);

            currDigit = bint.divide(divisor);
            sum = sum.add(currDigit);
            bint = bint.mod(divisor);
        } while (currDigit.compareTo(BigInteger.ZERO) > 0);

        return sum;
    }

    public static BigInteger findNearestPowerOfTen(BigInteger bint) {
        BigInteger divisor = BigInteger.ONE;

        int length = bint.toString().length();
        for (int i = 0; i < length - 1; i++) {
            divisor = divisor.multiply(BigInteger.TEN);
        }

        return divisor;
    }
}